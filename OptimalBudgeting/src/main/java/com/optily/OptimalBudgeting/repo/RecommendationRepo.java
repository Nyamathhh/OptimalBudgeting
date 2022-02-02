/**
 * 
 */
package com.optily.OptimalBudgeting.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.optily.OptimalBudgeting.entities.Recommendation;

/**
 * @author shaik
 *
 */
@Repository
public interface RecommendationRepo extends JpaRepository<Recommendation, Integer> {
	
	public List<Recommendation> findByOptimisationId(int optimisationId);
	public List<Recommendation> findByCampaignId(int campaignId);
	
}
