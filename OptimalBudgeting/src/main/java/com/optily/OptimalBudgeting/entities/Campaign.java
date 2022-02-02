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
@Table(name ="Campaign", schema ="optily", catalog ="localH2")
public class Campaign {
	private int campaignGrpId;
	private int campaignId;
	private String name;
	private BigDecimal budget;
	private BigDecimal impressions;
	private BigDecimal revenue;
	
	@Basic
	@Column(name ="campaignGrpId", nullable = false, length = 50)
	public int getCampaignGrpId() {
		return campaignGrpId;
	}
	
	public void setCampaignGrpId(int campaignGrpId) {
		this.campaignGrpId = campaignGrpId;
	}
	
	@Basic
	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 100)
	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	@Basic
	@Column(name = "budget", nullable = true)
	public BigDecimal getBudget() {
		return budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}

	@Basic
	@Column(name = "impressions", nullable = true)
	public BigDecimal getImpressions() {
		return impressions;
	}

	public void setImpressions(BigDecimal impressions) {
		this.impressions = impressions;
	}

	@Basic
	@Column(name = "revenue", nullable = true)
	public BigDecimal getRevenue() {
		return revenue;
	}

	public void setRevenue(BigDecimal revenue) {
		this.revenue = revenue;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(budget, campaignGrpId, campaignId, impressions, name, revenue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campaign other = (Campaign) obj;
		return Objects.equals(budget, other.budget) && campaignGrpId == other.campaignGrpId
				&& campaignId == other.campaignId && Objects.equals(impressions, other.impressions)
				&& Objects.equals(name, other.name) && Objects.equals(revenue, other.revenue);
	}

	@Override
	public String toString() {
		return "Campaign [campaignGrpId=" + campaignGrpId + ", campaignId=" + campaignId + ", name=" + name
				+ ", budget=" + budget + ", impressions=" + impressions + ", revenue=" + revenue + "]";
	}

	
}
