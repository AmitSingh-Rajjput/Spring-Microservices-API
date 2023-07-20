package com.training.departmentservices.service;

import org.springframework.stereotype.Service;

import com.training.departmentservices.dto.DepartmentDto;


public interface DepartmentService {
	
	DepartmentDto saveDepartment(DepartmentDto departmentDto);
	
	DepartmentDto getDepartmentByCode(String code);
}
