package com.service.intelligence.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.service.intelligence.dto.OrganizationDTO;

public interface OrganizationService {

	public String createOrganization(OrganizationDTO organizationDTO) throws JsonProcessingException;

	public String getOrganizationDetails(String searchParam) throws JsonProcessingException;

	public String updateOrganization(OrganizationDTO organizationDTO) throws JsonProcessingException;

	public String deleteOrganizationById(long orgId) throws JsonProcessingException;
	
	public boolean isValidOrganizationName(OrganizationDTO organizationDTO);
	
	public boolean isValidOrganizationEmail(OrganizationDTO organizationDTO);
	
}
