/**
 * 
 */
package com.optily.OptimalBudgeting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optily.OptimalBudgeting.entities.Campaign;
import com.optily.OptimalBudgeting.entities.CampaignGroup;
import com.optily.OptimalBudgeting.repo.CampaignGroupRepo;
import com.optily.OptimalBudgeting.repo.CampaignRepo;

/**
 * @author shaik
 *
 */

@Service
public class CampaignService {

	@Autowired
	CampaignRepo campaignRepo;
	@Autowired
	CampaignGroupRepo campaignGroupRepo;
	
	public List<Campaign> getAllCampaignByGrp(String cg) {
		CampaignGroup cgList = campaignGroupRepo.findByName(cg);
		return campaignRepo.findByCampaignGrpId(cgList.getCampaignGrpId());
	}
	
	
}
