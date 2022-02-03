/**
 * 
 */
package com.optily.OptimalBudgeting.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optily.OptimalBudgeting.Constants;
import com.optily.OptimalBudgeting.entities.Campaign;
import com.optily.OptimalBudgeting.entities.CampaignGroup;
import com.optily.OptimalBudgeting.entities.Optimisation;
import com.optily.OptimalBudgeting.entities.Recommendation;
import com.optily.OptimalBudgeting.repo.CampaignGroupRepo;
import com.optily.OptimalBudgeting.repo.CampaignRepo;
import com.optily.OptimalBudgeting.repo.OptimisationRepo;
import com.optily.OptimalBudgeting.repo.RecommendationRepo;

/**
 * @author shaik
 *
 */

@Service
public class OptimisationService {

	@Autowired
	CampaignGroupRepo campaignGroupRepo;

	@Autowired
	CampaignRepo campaignRepo;

	@Autowired
	RecommendationRepo recommendationRepo;

	@Autowired
	OptimisationRepo optimisationRepo;

	public List<Optimisation> getAllOptimisationsByGrp(String cg) {
		CampaignGroup cgList = campaignGroupRepo.findByName(cg);
		List<Campaign> cList = campaignRepo.findAll();
		List<Recommendation> rList = recommendationRepo.findAll();
		optimise(cList, rList);
		return optimisationRepo.findByCampaignGrpId(cgList.getCampaignGrpId());
	}

	private void optimise(List<Campaign> cList, List<Recommendation> rList) {
		BigDecimal totalImpressions = BigDecimal.ZERO;
		BigDecimal totalBudget = BigDecimal.ZERO;

		for (Campaign c : cList) {
			totalBudget = totalBudget.add(c.getBudget());
			totalImpressions = totalImpressions.add(c.getImpressions());
		}

		for (Recommendation r : rList) {
			Campaign c = campaignRepo.findByCampaignId(r.getCampaignId());
			BigDecimal recommendedBudget = (c.getImpressions().divide(totalImpressions, 2, RoundingMode.HALF_UP))
					.multiply(totalBudget);

			if (recommendedBudget.compareTo(c.getBudget()) != 0) {
				List<Optimisation> oList = optimisationRepo.findByCampaignGrpId(c.getCampaignGrpId());
				oList.get(0).setStatus(Constants.NOT_APPLIED);
				r.setRecommendationBudget(recommendedBudget);
				optimisationRepo.saveAll(oList);
				recommendationRepo.save(r);
			}
		}
	}

	public String apply(Optimisation op) {
		try {
			Optimisation optimisation = optimisationRepo.findByOptimisationId(op.getOptimisationId());
			optimisation.setStatus(op.getStatus());
			List<Recommendation> rList = recommendationRepo.findByOptimisationId(op.getOptimisationId());

			for (Recommendation r : rList) {
				if (op.getStatus().equalsIgnoreCase(Constants.APPLIED)) {
					Campaign c = campaignRepo.findByCampaignId(r.getCampaignId());
					c.setBudget(r.getRecommendationBudget());
					campaignRepo.save(c);
					recommendationRepo.delete(r);
				} else {
					recommendationRepo.delete(r);
				}
			}
		} catch (Exception e) {
			System.out.println("Exception while applying Recommendations.." + e);
			return Constants.FAILURE;
		}
		return Constants.SUCCESS;
	}
}
