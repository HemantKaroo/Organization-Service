package com.service.intelligence.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.service.intelligence.constants.ServiceConstants;
import com.service.intelligence.dto.OrganizationDTO;
import com.service.intelligence.dto.SearchOrganizationDTO;
import com.service.intelligence.service.OrganizationService;

@RestController
@RequestMapping("/organizationservice")
public class OrganizationController {

	@Autowired
	OrganizationService organizationService;

	@PostMapping("/createOrganization")
	@ResponseBody
	public ResponseEntity<String> createOrganization(@Valid @RequestBody OrganizationDTO organizationDto)
			throws JsonProcessingException {
		String organizationCreate = organizationService.createOrganization(organizationDto);
		if (organizationCreate != null && !organizationCreate.isEmpty()) {
			return new ResponseEntity<>(organizationCreate, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ServiceConstants.Request_Fail, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/organizationUpdate")
	@ResponseBody
	public ResponseEntity<String> updateOrganization(@Valid @RequestBody OrganizationDTO organizationDto)
			throws JsonProcessingException {
		String organizationUpdate = organizationService.updateOrganization(organizationDto);
		if (organizationUpdate != null && !organizationUpdate.isEmpty()) {
			return new ResponseEntity<>(organizationUpdate, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ServiceConstants.Request_Fail, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/getOrganizations")
	@ResponseBody
	public ResponseEntity<String> getOrganizations(@RequestBody SearchOrganizationDTO searchOrganizaionDto)
			throws JsonProcessingException {
		String organizations = organizationService.getOrganizationDetails(searchOrganizaionDto.getSearchParam());
		if (organizations != null && !organizations.isEmpty()) {
			return new ResponseEntity<>(organizations, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ServiceConstants.Request_Fail, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("deleteOrganizationById/{orgId}")
	public ResponseEntity<String> deleteOrganization(@PathVariable(value = "orgId") long orgId)
			throws JsonProcessingException {
		String deleteOrgId = organizationService.deleteOrganizationById(orgId);
		if (deleteOrgId != null && !deleteOrgId.isEmpty()) {
			return new ResponseEntity<>(deleteOrgId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ServiceConstants.Request_Fail, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
