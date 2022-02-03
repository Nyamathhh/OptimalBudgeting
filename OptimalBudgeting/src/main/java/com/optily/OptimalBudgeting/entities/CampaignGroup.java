/**
 * 
 */
package com.optily.OptimalBudgeting.entities;

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
@Table(name ="Campaign_Group", schema ="optily", catalog ="localH2")
public class CampaignGroup {
	private int campaignGrpId;
	private String name;
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id", nullable = false, length = 50)
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

	@Override
	public String toString() {
		return "CampaignGroup [campaignGrpId=" + campaignGrpId + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(campaignGrpId, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CampaignGroup other = (CampaignGroup) obj;
		return campaignGrpId == other.campaignGrpId && Objects.equals(name, other.name);
	}
	
}
