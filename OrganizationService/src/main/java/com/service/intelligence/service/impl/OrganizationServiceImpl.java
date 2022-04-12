package com.service.intelligence.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.intelligence.dto.OrganizationDTO;
import com.service.intelligence.model.Organization;
import com.service.intelligence.repository.OrganizationRepository;
import com.service.intelligence.service.OrganizationService;

@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;

	@Override
	public String createOrganization(OrganizationDTO organizationDto) throws JsonProcessingException {
		Organization organization = new Organization();
		organization.setName(organizationDto.getName());
		organization.setPhoneOne(organizationDto.getPhoneOne());
		organization.setPhoneTwo(organizationDto.getPhoneTwo());
		organization.setEmailOne(organizationDto.getEmailOne());
		organization.setEmailTwo(organizationDto.getEmailTwo());
		organization.setAddress(organizationDto.getAddress());
		organization.setCity(organizationDto.getCity());
		organization.setState(organizationDto.getState());
		organization.setCountry(organizationDto.getCountry());
		organization.setZipcode(organizationDto.getZipcode());
		String isActive = "true";
		organization.setActive(isActive);
		organization.setCreateById(organizationDto.getCreateById());
		Date date = new Date();
		organization.setCreateDate(date);
		ObjectMapper objectMapper = new ObjectMapper();
		String organizationSave = objectMapper.writeValueAsString(organizationRepository.save(organization));
		return organizationSave;
	}

	@Override
	public String getOrganizationDetails(String searchParam) throws JsonProcessingException {
		String organizationDetails = "";
		List<Organization> organizationList = organizationRepository.searchActiveOrganization(searchParam, "true");
		if (!organizationList.isEmpty()) {
			ObjectMapper objectMapper = new ObjectMapper();
			organizationDetails = objectMapper.writeValueAsString(organizationList);
		}
		return organizationDetails;
	}

	@Override
	public String updateOrganization(OrganizationDTO organizationDto) throws JsonProcessingException {
		String organizationUpdate = "";
		long orgId = organizationDto.getOrgId();
		Optional<Organization> organizationOptional = organizationRepository.findById(orgId);
		if (organizationOptional.isPresent()) {
			Organization organizationExist = organizationOptional.get();
			organizationExist.setName(organizationDto.getName());
			organizationExist.setPhoneOne(organizationDto.getPhoneOne());
			organizationExist.setPhoneTwo(organizationDto.getPhoneTwo());
			organizationExist.setEmailOne(organizationDto.getEmailOne());
			organizationExist.setEmailTwo(organizationDto.getEmailTwo());
			organizationExist.setAddress(organizationDto.getAddress());
			organizationExist.setCity(organizationDto.getCity());
			organizationExist.setState(organizationDto.getState());
			organizationExist.setCountry(organizationDto.getCountry());
			organizationExist.setZipcode(organizationDto.getZipcode());
			organizationExist.setUpdateById(organizationDto.getUpdateById());
			Date date = new Date();
			organizationExist.setUpdateDate(date);
			ObjectMapper objectMapper = new ObjectMapper();
			organizationUpdate = objectMapper.writeValueAsString(organizationRepository.save(organizationExist));
		}
		return organizationUpdate;
	}

	@Override
	public String deleteOrganizationById(long orgId) throws JsonProcessingException {
		String deleteOrganizationId = "";
		Optional<Organization> organizationOptional = organizationRepository.findById(orgId);
		if (organizationOptional.isPresent()) {
			Organization organizationExist = organizationOptional.get();
			String isActive = "false";
			organizationExist.setActive(isActive);
			organizationRepository.save(organizationExist);
			ObjectMapper objectMapper = new ObjectMapper();
			deleteOrganizationId = objectMapper.writeValueAsString(orgId);
		}
		return deleteOrganizationId;
	}

	@Override
	public boolean isValidOrganizationName(OrganizationDTO organizationDto) {
		boolean isValid = true;
		if (organizationRepository.findByName(organizationDto.getName()) != null) {
			isValid = false;
		}
		return isValid;
	}

	@Override
	public boolean isValidOrganizationEmail(OrganizationDTO organizationDto) {
		boolean isValid = true;
		if (organizationRepository.checkEmailId(organizationDto.getEmailOne()) != null) {
			isValid = false;
		}
		if (organizationRepository.checkEmailId(organizationDto.getEmailTwo()) != null) {
			isValid = false;
		}
		return isValid;
	}

}
