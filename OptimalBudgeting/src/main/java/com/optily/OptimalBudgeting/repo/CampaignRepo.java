/**
 * 
 */
package com.optily.OptimalBudgeting.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.optily.OptimalBudgeting.entities.Campaign;

/**
 * @author shaik
 *
 */
@Repository
public interface CampaignRepo extends JpaRepository<Campaign, Integer> {
	
	public List<Campaign> findByName(String name);
	
}
