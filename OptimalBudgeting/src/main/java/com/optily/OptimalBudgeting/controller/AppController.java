/**
 * 
 */
package com.optily.OptimalBudgeting.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.optily.OptimalBudgeting.model.OptilyResponse;
import com.optily.OptimalBudgeting.service.FileUploadService;

/**
 * @author shaik
 *
 */
@RestController
@RequestMapping(value = "/optily")
public class AppController {

	@Autowired
	FileUploadService fileUploadService;
	
	@RequestMapping(value ="/healthcheck", method = RequestMethod.GET)
	public String healthCheck() {
		return "Application started successfully";
	}
	
	@RequestMapping(value="/file/upload", method = RequestMethod.POST)
	public OptilyResponse upload(@RequestParam("file") MultipartFile file) {
//		MultipartFile mf = multipartFiles.get(0);
//		FileModel fileModel = null;
		String responseCode = "0001";
//		ObjectMapper mapper = new ObjectMapper();
//			Request<FileModel> fmodelRequest = mapper.readValue(fileModelJson, new TypeReference<Request<FileModel>>() {});
//			fileModel = fmodelRequest.getPayLoad();
//			fileModel.setMultipartFiles(multipartFiles);
		responseCode = fileUploadService.upload(file);
 		
		OptilyResponse op = new OptilyResponse();
		if("0000".equals(responseCode)) {
			op.setMessage("Successfully uploaded the file: " + file.getName());
		}
		else {
			op.setMessage("Failed to upload the file: " + file.getName());
		}
		
		op.setStatusCode(responseCode);
		
		return op;
		
	}
	
}
