package com.training.organizationservice.mapper;

import com.training.organizationservice.dto.OrganizationDto;
import com.training.organizationservice.entity.Organization;

public class OrganizationMapper {
	
	public static OrganizationDto mapToOrzanizationDto( Organization organization){
		OrganizationDto organizationDto = new OrganizationDto(
				organization.getId(),
				organization.getOrganizationName(),
				organization.getOrganizationDescription(),
				organization.getOrganizationCode(),
				organization.getCreatedDate());
		return organizationDto;
	}
	
	public static Organization mapToOrganization( OrganizationDto organizationDto){
		Organization organization = new Organization(
				organizationDto.getId(),
				organizationDto.getOrganizationName(),
				organizationDto.getOrganizationDescription(),
				organizationDto.getOrganizationCode(),
				organizationDto.getCreatedDate());
		return organization;
	}

}
