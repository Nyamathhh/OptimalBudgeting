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
	
	public Campaign findByName(String name);
	public List<Campaign> findByCampaignGrpId(int cgid);
	public Campaign findByCampaignId(int cid);
	
	
}
