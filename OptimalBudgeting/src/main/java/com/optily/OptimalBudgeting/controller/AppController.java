/**
 * 
 */
package com.optily.OptimalBudgeting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.optily.OptimalBudgeting.Constants;
import com.optily.OptimalBudgeting.entities.Campaign;
import com.optily.OptimalBudgeting.entities.CampaignGroup;
import com.optily.OptimalBudgeting.entities.Optimisation;
import com.optily.OptimalBudgeting.entities.Recommendation;
import com.optily.OptimalBudgeting.model.OptilyResponse;
import com.optily.OptimalBudgeting.repo.CampaignGroupRepo;
import com.optily.OptimalBudgeting.repo.CampaignRepo;
import com.optily.OptimalBudgeting.repo.OptimisationRepo;
import com.optily.OptimalBudgeting.repo.RecommendationRepo;
import com.optily.OptimalBudgeting.service.CampaignService;
import com.optily.OptimalBudgeting.service.FileUploadService;
import com.optily.OptimalBudgeting.service.OptimisationService;
import com.optily.OptimalBudgeting.service.RecommendationService;

/**
 * @author shaik
 *
 */
@RestController
@RequestMapping(value = "/optily")
public class AppController {

	@Autowired
	FileUploadService fileUploadService;
	
	@Autowired
	CampaignGroupRepo campaignGroupRepo;
	
	@Autowired
	CampaignRepo campaignRepo;
	
	
	@Autowired
	OptimisationRepo optimisationRepo;
	
	@Autowired
	RecommendationRepo recommendationRepo;
	
	
	@Autowired
	CampaignService campaignService;
	
	@Autowired
	OptimisationService optimisationService;
	
	@Autowired
	RecommendationService recommendationService;
	
	@RequestMapping(value ="/healthcheck", method = RequestMethod.GET)
	public String healthCheck() {
		return "Application started successfully";
	}
	
	@RequestMapping(value="/file/upload", method = RequestMethod.POST)
	public OptilyResponse upload(@RequestParam("file") MultipartFile file) {
		
		String responseCode = Constants.FAILURE;
		responseCode = fileUploadService.upload(file);
		
		OptilyResponse op = new OptilyResponse();
		if(Constants.SUCCESS.equals(responseCode)) {
			op.setMessage("Successfully uploaded the file: " + file.getName());
		}
		else {
			op.setMessage("Failed to upload the file: " + file.getName());
		}
		
		op.setStatusCode(responseCode);
		
		return op;
		
	}
	
	@RequestMapping(value="/campaigngroups", method = RequestMethod.GET)
	public List<CampaignGroup> getAllCampaignGroups() {
		return campaignGroupRepo.findAll();
	}

	@RequestMapping(value="/campaigns", method = RequestMethod.GET)
	public List<Campaign> getAllCampaigns() {
		return campaignRepo.findAll();
	}
	
	@RequestMapping(value="/optimisations", method = RequestMethod.GET)
	public List<Optimisation> getAllOptimisations() {
		return optimisationRepo.findAll();
	}
	
	@RequestMapping(value="/campaigns/{campaignGrp}", method = RequestMethod.GET)
	public List<Campaign> getCampaignByGrp(@PathVariable(name="campaignGrp") String cp) {
		return campaignService.getAllCampaignByGrp(cp);
	}
	
	@RequestMapping(value="/optimisations/{campaignGrp}", method = RequestMethod.GET)
	public List<Optimisation> getOptimisationsForCampaignGrp(@PathVariable(name="campaignGrp") String cp) {
		return optimisationService.getAllOptimisationsByGrp(cp);
	}
	
	@RequestMapping(value="/recommendations", method = RequestMethod.GET)
	public List<Recommendation> getAllRecommendations() {
		return recommendationRepo.findAll();
	}
	
	@RequestMapping(value="/recommendations/{optimisationId}", method=RequestMethod.GET)
	public List<Recommendation> getRecommendationsByOpti(@PathVariable(name="optimisationId") int optId) {
		return recommendationService.getAllRecomByOptimisation(optId);
	}
	
	@RequestMapping(value="apply/optimisations", method = RequestMethod.PUT)
	public OptilyResponse applyOptimisation(@RequestBody Optimisation optimisation) {
		String responseCode = Constants.FAILURE;
		responseCode = optimisationService.apply(optimisation);
		
		OptilyResponse op = new OptilyResponse();
		if(Constants.SUCCESS.equals(responseCode)) {
			op.setMessage("Successfully applied the optimisation: " + optimisation.getOptimisationId());
		}
		else {
			op.setMessage("Failed to apply the optimisation: " + optimisation.getOptimisationId());
		}
		
		op.setStatusCode(responseCode);
		
		return op;
	}
}
