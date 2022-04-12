package com.service.intelligence.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.service.intelligence.dto.OrganizationDTO;
import com.service.intelligence.model.Organization;
import com.service.intelligence.repository.OrganizationRepository;
import com.service.intelligence.service.impl.OrganizationServiceImpl;

@ExtendWith(MockitoExtension.class)
public class OrganizationServiceImplTest {

	@Mock
	private OrganizationRepository organizationRepository;

	@InjectMocks
	OrganizationServiceImpl organizationService;

	Date date = new Date();

	@Test
	void createOrganizationTest() {
		Organization organization = new Organization(1, "TCS Mumbai", "makarba ahemdabad", "0987654321", "1234567890",
				"tcsinindia@gmail.com", "tcsindia@gmail.com", "ahemedabad", "gujrat", "india", "123456", "true", 123, 0,
				date, date);
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
		Mockito.when(organizationRepository.save(organization)).thenReturn(organization);
		// Organization organizationPersited =
		// organizationService.createOrganization(organizationDto);
		// assertEquals(organization.getOrgId(), organizationPersited.getOrgId());
		verify(organizationRepository, timeout(1)).save(organization);
	}

	@Test
	void getOrganizationDetailsTest() {
		Organization firstOrganization = new Organization(1, "TCS Mumbai", "makarba ahemdabad", "0987654321",
				"1234567890", "tcsinindia@gmail.com", "tcsindia@gmail.com", "ahemedabad", "gujrat", "india", "123456",
				"true", 123, 0, date, date);
		Organization secondOrganization = new Organization(2, "TCS Nagpur", "makarba ahemdabad", "0987654321",
				"1234567890", "tcsinindia@gmail.com", "tcsindia@gmail.com", "ahemedabad", "gujrat", "india", "123456",
				"true", 123, 0, date, date);
		List<Organization> organizationList = new ArrayList<Organization>();
		organizationList.add(firstOrganization);
		organizationList.add(secondOrganization);
		Mockito.when(organizationRepository.searchActiveOrganization("123456", "true")).thenReturn(organizationList);
	//	assertThat(organizationService.getOrganizationDetails("123456")).isEqualTo(organizationList);
	}

}
