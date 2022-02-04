/**
 * 
 */
package com.optily.OptimalBudgeting.entities;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author shaik
 *
 */
@Entity
@Table(name ="Optimisation", schema ="optily", catalog ="localH2")
public class Optimisation {
	private int optimisationId;
	private int campaignGrpId;
	private String status;
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="optimisationId", nullable = false, length = 50)
	public int getOptimisationId() {
		return optimisationId;
	}

	public void setOptimisationId(int optimisationId) {
		this.optimisationId = optimisationId;
	}

	
	@Basic
	@Column(name = "status", nullable = false, length = 100)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Basic
	@Column(name = "campaignGrpId", nullable = false, length = 100)
	public int getCampaignGrpId() {
		return campaignGrpId;
	}
	
	public void setCampaignGrpId(int campaignGrpId) {
		this.campaignGrpId = campaignGrpId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(campaignGrpId, optimisationId, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Optimisation other = (Optimisation) obj;
		return campaignGrpId == other.campaignGrpId && optimisationId == other.optimisationId
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Optimisation [optimisationId=" + optimisationId + ", campaignGrpId=" + campaignGrpId + ", status="
				+ status + "]";
	}
	
		
}
