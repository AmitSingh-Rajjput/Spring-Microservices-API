package com.training.departmentservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
		description="DepartmentDto model information"
		)
public class DepartmentDto {
	

@Schema(
		description="Department Id"
		)
	private Long id;

@Schema(
		description="Department Name"
		)
	private String departmentName;

@Schema(
		description="Department Description"
		)
	private String departmentDescription;

@Schema(
		description="Department Code"
		)
	private String departmentCode;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentDescription() {
		return departmentDescription;
	}
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public DepartmentDto(Long id, String departmentName, String departmentDescription, String departmentCode) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.departmentDescription = departmentDescription;
		this.departmentCode = departmentCode;
	}
	public DepartmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
