package com.training.organizationservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.organizationservice.dto.OrganizationDto;
import com.training.organizationservice.entity.Organization;
import com.training.organizationservice.mapper.OrganizationMapper;
import com.training.organizationservice.repository.OrganizationRepository;
import com.training.organizationservice.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Override
	public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
		// Convert organizationdto into organization
		Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
		
		Organization savedOrganization = organizationRepository.save(organization);
		
		//Convert organization into organizationdto
		
		return OrganizationMapper.mapToOrzanizationDto(savedOrganization);
	}

	@Override
	public OrganizationDto getOrganizationByCode(String organizationCode) {
		Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
		return OrganizationMapper.mapToOrzanizationDto(organization);
	}

}
