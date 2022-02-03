/**
 * 
 */
package com.optily.OptimalBudgeting.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.optily.OptimalBudgeting.entities.CampaignGroup;

/**
 * @author shaik
 *
 */
@Repository
public interface CampaignGroupRepo extends JpaRepository<CampaignGroup, Integer> {

	public CampaignGroup findByName(String name);
}
