/**
 * 
 */
package com.optily.OptimalBudgeting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optily.OptimalBudgeting.repo.CampaignGroupRepo;
import com.optily.OptimalBudgeting.repo.CampaignRepo;
import com.optily.OptimalBudgeting.repo.OptimisationRepo;
import com.optily.OptimalBudgeting.repo.RecommendationRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

/**
 * @author shaik
 *
 */
@Service
public class DeleteService {

	EntityManager entityManager;
	
	@Autowired
	CampaignGroupRepo campaignGroupRepo;
	@Autowired
	CampaignRepo campaignRepo;
	@Autowired
	OptimisationRepo optimisationRepo;
	@Autowired
	RecommendationRepo recommendationRepo;
	
	@Autowired
	public void TruncateDatabaseService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Transactional
	public void delete() {
		entityManager.flush();
		entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();
		if(campaignGroupRepo.count()>0)
			entityManager.createNativeQuery("TRUNCATE TABLE OPTILY.CAMPAIGN_GROUP").executeUpdate();
		if(campaignRepo.count()>0)
			entityManager.createNativeQuery("TRUNCATE TABLE OPTILY.CAMPAIGN").executeUpdate();
		if(optimisationRepo.count()>0)
			entityManager.createNativeQuery("TRUNCATE TABLE OPTILY.OPTIMISATION").executeUpdate();
		if(recommendationRepo.count()>0)
			entityManager.createNativeQuery("TRUNCATE TABLE OPTILY.RECOMMENDATION").executeUpdate();
		
		entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();
	}
}
