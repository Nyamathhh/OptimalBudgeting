/**
 * 
 */
package com.optily.OptimalBudgeting.entities;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author shaik
 *
 */
@Entity
@Table(name ="Recommendation", schema ="optily", catalog ="localH2")
public class Recommendation {
	private int recommendationId;
	private int optimisationId;
	private int campaignId;
	private BigDecimal recommendationBudget;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recommendationId", nullable = false, length = 50)
	public int getRecommendationId() {
		return recommendationId;
	}
	public void setRecommendationId(int recommendationId) {
		this.recommendationId = recommendationId;
	}
	
	@Basic
	@Column(name = "optimisationId", nullable = true, length = 50)
	public int getOptimisationId() {
		return optimisationId;
	}
	public void setOptimisationId(int optimisationId) {
		this.optimisationId = optimisationId;
	}
	
	@Basic
	@Column(name = "campaignId", nullable = true, length = 50)
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	
	@Basic
	@Column(name = "recommendationBudget", nullable = true)
	public BigDecimal getRecommendationBudget() {
		return recommendationBudget;
	}
	public void setRecommendationBudget(BigDecimal recommendationBudget) {
		this.recommendationBudget = recommendationBudget;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(campaignId, optimisationId, recommendationBudget, recommendationId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recommendation other = (Recommendation) obj;
		return campaignId == other.campaignId && optimisationId == other.optimisationId
				&& Objects.equals(recommendationBudget, other.recommendationBudget)
				&& recommendationId == other.recommendationId;
	}
	@Override
	public String toString() {
		return "Recommendation [recommendationId=" + recommendationId + ", optimisationId=" + optimisationId
				+ ", campaignId=" + campaignId + ", recommendationBudget=" + recommendationBudget + "]";
	}
	
	
		
}
