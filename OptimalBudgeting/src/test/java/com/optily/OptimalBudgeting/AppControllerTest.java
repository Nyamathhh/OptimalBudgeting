/**
 * 
 */
package com.optily.OptimalBudgeting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.optily.OptimalBudgeting.entities.Campaign;
import com.optily.OptimalBudgeting.entities.CampaignGroup;
import com.optily.OptimalBudgeting.entities.Optimisation;
import com.optily.OptimalBudgeting.entities.Recommendation;
import com.optily.OptimalBudgeting.service.FileUploadService;

/**
 * @author shaik
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class AppControllerTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@MockBean
	private FileUploadService fileService;

	@Autowired
	MockMvc mockMvc;

	@Value("${app.document-root}")
	String documentRoot;

	@Test
	public void test_Upload() throws Exception {

		String fileName = "campaigns.csv";
		MockMultipartFile sampleFile = new MockMultipartFile("file", fileName, "text/plain",
				"This is the file content".getBytes());

		MockMultipartHttpServletRequestBuilder multipartRequest = MockMvcRequestBuilders
				.multipart("/optily/file/upload");

		mockMvc.perform(multipartRequest.file(sampleFile)).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void test_Upload_NoFileProvided() throws Exception {
		MockMultipartHttpServletRequestBuilder multipartRequest = MockMvcRequestBuilders
				.multipart("/optily/file/upload");

		mockMvc.perform(multipartRequest).andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void getAllCampaignGroups() throws Exception {
		String uri = "/optily/campaigngroups";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		CampaignGroup[] campaignGroupList = super.mapFromJson(content, CampaignGroup[].class);
		assertTrue(campaignGroupList.length > 0);
	}

	@Test
	public void getAllCampaigns() throws Exception {
		String uri = "/optily/campaigns";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Campaign[] campaignList = super.mapFromJson(content, Campaign[].class);
		assertTrue(campaignList.length > 0);
	}

	@Test
	public void getAllOptimisations() throws Exception {
		String uri = "/optily/optimisations";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Optimisation[] optimisationList = super.mapFromJson(content, Optimisation[].class);
		assertTrue(optimisationList.length > 0);
	}

	@Test
	public void getCampaignByGrp() throws Exception {
		String uri = "/optily/campaigns/A_CV_SHP";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Campaign[] campaignList = super.mapFromJson(content, Campaign[].class);
		assertTrue(campaignList.length > 0);
	}

	@Test
	public void getOptimisationsForCampaignGrp() throws Exception {
		String uri = "/optily/optimisations/A_CV_SHP";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Optimisation[] campaignList = super.mapFromJson(content, Optimisation[].class);
		assertTrue(campaignList.length > 0);
	}

	@Test
	public void getAllRecommendations() throws Exception {
		String uri = "/optily/recommendations";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Recommendation[] recomList = super.mapFromJson(content, Recommendation[].class);
		assertTrue(recomList.length > 0);
	}

	@Test
	public void getRecommendationsByOpti() throws Exception {
		String uri = "/optily/recommendations/301";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Recommendation[] recomList = super.mapFromJson(content, Recommendation[].class);
		assertTrue(recomList.length > 0);
	}

	@Test
	public void applyOptimisation() throws Exception {
		String uri = "/optily/apply/optimisations";
		Optimisation product = new Optimisation();
	      product.setStatus("applied");
	      product.setCampaignGrpId(102);
	      product.setOptimisationId(302);
	      String inputJson = super.mapToJson(product);
	      MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	}
}
