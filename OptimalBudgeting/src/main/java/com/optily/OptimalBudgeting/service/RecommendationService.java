/**
 * 
 */
package com.optily.OptimalBudgeting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optily.OptimalBudgeting.entities.Recommendation;
import com.optily.OptimalBudgeting.repo.RecommendationRepo;

/**
 * @author shaik
 *
 */

@Service
public class RecommendationService {
	
	@Autowired
	RecommendationRepo recommendationRepo;
	
	public List<Recommendation> getAllRecomByOptimisation(int opId) {
		return recommendationRepo.findByOptimisationId(opId);
	}
}
