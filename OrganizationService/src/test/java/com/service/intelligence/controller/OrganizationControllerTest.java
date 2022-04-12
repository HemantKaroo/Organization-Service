package com.service.intelligence.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.service.intelligence.model.Organization;
import com.service.intelligence.service.OrganizationService;

@WebMvcTest(OrganizationController.class)
class OrganizationControllerTest {

	@MockBean
	OrganizationService organizationService;

	@Autowired
	protected MockMvc mockMvc;

	Date date = new Date();

	@Test
	void getOrganizationDetailsTest() throws Exception {
		Organization firstOrganization = new Organization(1, "TCS Mumbai", "makarba ahemdabad", "0987654321",
				"1234567890", "tcsinindia@gmail.com", "tcsindia@gmail.com", "ahemedabad", "gujrat", "india", "123456",
				"", 123, 0, date, date);
		Organization secondOrganization = new Organization(2, "TCS Nagpur", "makarba ahemdabad", "0987654321",
				"1234567890", "tcsinindia@gmail.com", "tcsindia@gmail.com", "ahemedabad", "gujrat", "india", "123456",
				"", 123, 0, date, date);
		List<Organization> organizationList = new ArrayList<Organization>();
		organizationList.add(firstOrganization);
		organizationList.add(secondOrganization);
		//Mockito.when(organizationService.getOrganizationDetails("123456")).thenReturn(organizationList);
		String uri = "/organizationService/getOrganizations?searchParam=123456";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		//String expectedResult = new Gson().toJson(organizationList);
		String actualResult = result.getResponse().getContentAsString();
		//assertThat(actualResult).isEqualTo(expectedResult);
	}
/*
	@Test
	void createOrganizationTest() throws Exception {
		Organization organization = new Organization(0, "TCS Mumbai", "makarba ahemdabad", "0987654321", "1234567890",
				"tcsinindia@gmail.com", "tcsindia@gmail.com", "ahemedabad", "gujrat", "india", "123456", "true", 123, 0,
				null, null);
		OrganizationDTO organizationDto = new OrganizationDTO();
		organizationDto.setName(organization.getName());
		organizationDto.setAddress(organization.getAddress());
		organizationDto.setPhoneOne(organization.getPhoneOne());
		organizationDto.setPhoneTwo(organization.getPhoneTwo());
		organizationDto.setEmailOne(organization.getEmailOne());
		organizationDto.setEmailTwo(organization.getEmailTwo());
		organizationDto.setCity(organization.getCity());
		organizationDto.setState(organization.getState());
		organizationDto.setCountry(organization.getCountry());
		organizationDto.setZipcode(organization.getZipcode());
		organizationDto.setActive(organization.getActive());
		organizationDto.setCreateById(organization.getCreateById());
		organizationDto.setUpdateById(organization.getUpdateById());
		organizationDto.setCreateDate(organization.getCreateDate());
		organizationDto.setUpdateDate(organization.getUpdateDate());

		
		//String uri = "/organizationService/createOrganization";
		// Mockito.when(organizationService.createOrganization(organizationDto)).thenReturn(organization);
		//RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON)
				//.content(inputResult).contentType(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();

		String outputResult = response.getContentAsString();
		assertEquals(outputResult, inputResult);

	}
*/
}
