/**
 * 
 */
package com.optily.OptimalBudgeting.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.optily.OptimalBudgeting.entities.Optimisation;

/**
 * @author shaik
 *
 */
@Repository
public interface OptimisationRepo extends JpaRepository<Optimisation, Integer> {
	
	public List<Optimisation> findByCampaignGrpId(int campaignGrpId);
	
}
