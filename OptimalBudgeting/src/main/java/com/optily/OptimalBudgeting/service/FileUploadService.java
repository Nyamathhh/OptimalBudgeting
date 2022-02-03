/**
 * 
 */
package com.optily.OptimalBudgeting.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.optily.OptimalBudgeting.entities.Campaign;
import com.optily.OptimalBudgeting.entities.CampaignGroup;
import com.optily.OptimalBudgeting.entities.Optimisation;
import com.optily.OptimalBudgeting.entities.Recommendation;
import com.optily.OptimalBudgeting.repo.CampaignGroupRepo;
import com.optily.OptimalBudgeting.repo.CampaignRepo;
import com.optily.OptimalBudgeting.repo.OptimisationRepo;
import com.optily.OptimalBudgeting.repo.RecommendationRepo;


/**
 * @author shaik
 *
 */

@Component
public class FileUploadService {

	@Autowired
	CampaignGroupRepo campaignGroupRepo;
	@Autowired
	CampaignRepo campaignRepo;
	@Autowired
	OptimisationRepo optimisationRepo;
	@Autowired
	RecommendationRepo recommendationRepo;
	@Autowired
	DeleteService deleteService;

	public String upload(MultipartFile file) {
		try {
			
			deleteService.delete();
			
			Reader reader = new InputStreamReader(file.getInputStream());
			BufferedReader br = new BufferedReader(reader);
			processUpload(br);
		} catch (Exception e) {
			return "0001";
		}
		return "0000";
	}

	private void processUpload(BufferedReader br) throws Exception {

		List<CampaignGroup> cgList = new ArrayList<CampaignGroup>();
		List<Campaign> cList = new ArrayList<Campaign>();
		List<Optimisation> oList = new ArrayList<Optimisation>();
		List<Recommendation> rList = new ArrayList<Recommendation>();

		int cgid = 100;
		int cid = 200;
		int oid = 300;
		int rid = 400;

		String line = "";
		String splitBy = ",";
		try {
			br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			while ((line = br.readLine()) != null) // returns a Boolean value
			{

				CampaignGroup cg = new CampaignGroup();
				Campaign camp = new Campaign();
				Optimisation op = new Optimisation();
				Recommendation rec = new Recommendation();

				String[] campaignData = line.split(splitBy); // use comma as separator
				String name = campaignData[0];
				String budget = campaignData[1];
				String impressions = campaignData[2];

				if (campaignData[0] != null) {
					String[] campaignGrpArr = campaignData[0].split("-");
					String campaignGrp = campaignGrpArr[campaignGrpArr.length - 1];

					if (!cgList.stream().anyMatch(o -> o.getName().equals(campaignGrp))) {
						cg.setName(campaignGrp);
						cg.setCampaignGrpId(cgid);
						cgid++;
						cgList.add(cg);

						op.setOptimisationId(oid);
						oid++;
						op.setCampaignGrpId(cg.getCampaignGrpId());
						op.setStatus("");
						oList.add(op);
					}
					if (!cList.stream().anyMatch(o -> o.getName().equals(name))) {
						camp.setName(name);
						camp.setBudget(new BigDecimal(budget));
						camp.setImpressions(new BigDecimal(impressions));
						camp.setRevenue(new BigDecimal(budget));
						camp.setCampaignGrpId(cgList.stream().filter(c -> c.getName().equals(campaignGrp)).findAny()
								.orElse(null).getCampaignGrpId());
						camp.setCampaignId(cid);
						cid++;
						cList.add(camp);

						rec.setCampaignId(camp.getCampaignId());
						rec.setOptimisationId(
								oList.stream().filter(c -> c.getCampaignGrpId() == (camp.getCampaignGrpId())).findAny()
										.orElse(null).getOptimisationId());
						rec.setRecommendationBudget(BigDecimal.ZERO);
						rec.setRecommendationId(rid);
						rid++;
						rList.add(rec);

					} else {
						camp.setName(name);
						camp.setBudget(new BigDecimal(budget));
						camp.setImpressions(new BigDecimal(impressions));
						camp.setRevenue(new BigDecimal(budget).add(cList.stream().filter(c -> c.getName().equals(name))
								.findAny().orElse(null).getBudget()));
						camp.setCampaignGrpId(cgList.stream().filter(c -> c.getName().equals(campaignGrp)).findAny()
								.orElse(null).getCampaignGrpId());
						camp.setCampaignId(cid);
						cid++;
						cList.add(camp);

						rec.setCampaignId(camp.getCampaignId());
						rec.setOptimisationId(
								oList.stream().filter(c -> c.getCampaignGrpId() == (camp.getCampaignGrpId())).findAny()
										.orElse(null).getOptimisationId());
						rec.setRecommendationBudget(BigDecimal.ZERO);
						rec.setRecommendationId(rid);
						rid++;
						rList.add(rec);
					}

				}
			}
		} catch (Exception e) {
			System.out.println("Error while uploading the Campaign file.." + e);
			throw e;
		}
		campaignGroupRepo.saveAll(cgList);
		campaignRepo.saveAll(cList);
		optimisationRepo.saveAll(oList);
		recommendationRepo.saveAll(rList);
		return;
	}

}
