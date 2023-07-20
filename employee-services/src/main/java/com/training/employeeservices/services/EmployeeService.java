package com.training.employeeservices.services;

import com.training.employeeservices.dto.APIResponseDto;
import com.training.employeeservices.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	APIResponseDto getEmployeeById(Long id);

}
