package com.training.organizationservice.service;

import org.springframework.stereotype.Service;

import com.training.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
	
	OrganizationDto saveOrganization(OrganizationDto organizationDto);

	OrganizationDto getOrganizationByCode(String organizationCode);
}
