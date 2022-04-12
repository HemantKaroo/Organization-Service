package com.service.intelligence.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.service.intelligence.dto.OrganizationDTO;
import com.service.intelligence.service.OrganizationService;

public class OrganizationNameValidator implements ConstraintValidator<InvalidOrganizationName, OrganizationDTO> {

	@Autowired
	OrganizationService organizationService;

	@Override
	public boolean isValid(OrganizationDTO organizationDto, ConstraintValidatorContext context) {
		return (organizationService.isValidOrganizationName(organizationDto));
	}

}
