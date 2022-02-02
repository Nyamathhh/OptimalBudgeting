/**
 * 
 */
package com.optily.OptimalBudgeting.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author shaik
 *
 */
public class FileModel {

	private MetaDataModel metaData;
	
	private List<MultipartFile> multipartFiles;

	public MetaDataModel getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaDataModel metaData) {
		this.metaData = metaData;
	}

	public List<MultipartFile> getMultipartFiles() {
		return multipartFiles;
	}

	public void setMultipartFiles(List<MultipartFile> multipartFiles) {
		this.multipartFiles = multipartFiles;
	}
	
	
}
