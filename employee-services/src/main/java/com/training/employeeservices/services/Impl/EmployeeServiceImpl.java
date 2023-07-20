package com.training.employeeservices.services.Impl;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.training.employeeservices.dto.APIResponseDto;
import com.training.employeeservices.dto.DepartmentDto;
import com.training.employeeservices.dto.EmployeeDto;
import com.training.employeeservices.dto.OrganizationDto;
import com.training.employeeservices.entity.Employee;
import com.training.employeeservices.repository.EmployeeRepository;
import com.training.employeeservices.services.APIClient;
import com.training.employeeservices.services.EmployeeService;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
//	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient webclient;
	
	@Autowired
	private APIClient apiClient;
	
	// For logging 
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee = new Employee(
				employeeDto.getId(),employeeDto.getFirstName(),
				employeeDto.getLastName(),employeeDto.getEmail(),
				employeeDto.getDepartmentCode(),
				employeeDto.getDepartmentCode());
		
		Employee savedEmployee = employeeRepository.save(employee);
		
		EmployeeDto newEmployee = new EmployeeDto(
				savedEmployee.getId(),savedEmployee.getFirstName(),
				savedEmployee.getLastName(),savedEmployee.getEmail(),
				savedEmployee.getDepartmentCode(),
				savedEmployee.getDepartmentCode());
		
		return newEmployee;
	}

//	@CircuitBreaker(name="${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Retry(name="${spring.application.name}",fallbackMethod ="getDefaultDepartment" )
	@Override
	public APIResponseDto getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		
		LOGGER.info("Inside getEmployeeById() method");
		
		Employee employee = employeeRepository.findById(id).get();
		
//		EmployeeDto getEmployee = new EmployeeDto(
//				employee.getId(),employee.getFirstName(),
//				employee.getLastName(),employee.getEmail(),
//				employee.getDepartmentCode());
		
//		ResponseEntity<DepartmentDto> responseEntity =  restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), 
//				DepartmentDto.class);
//		
//		DepartmentDto departmentDto = responseEntity.getBody();
		
		DepartmentDto departmentDto = webclient.get()
		.uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
		.retrieve()
		.bodyToMono(DepartmentDto.class)
		.block();
		
		System.out.println(employee.getDepartmentCode());
		
		//ResponseEntity<DepartmentDto> departmentDto = apiClient.getDepartment(getEmployee.getDepartmentCode());
		
		OrganizationDto organizationDto = webclient.get()
				.uri("http://localhost:8083/api/organization/"+employee.getOrganizationCode())
				.retrieve()
				.bodyToMono(OrganizationDto.class)
				.block();
		
		EmployeeDto getEmployee = new EmployeeDto(
				employee.getId(),employee.getFirstName(),
				employee.getLastName(),employee.getEmail(),
				employee.getDepartmentCode(),
				employee.getDepartmentCode());
		
		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setDepartmentDto(departmentDto);
		apiResponseDto.setEmployeeDto(getEmployee);
		apiResponseDto.setOrganizationDto(organizationDto);
		
		return apiResponseDto;
	}
	
	public APIResponseDto getDefaultDepartment(Long id,Exception exception) {
		
		LOGGER.info("Inside getDefaultDepartment() method");
		
		        Employee employee = employeeRepository.findById(id).get();
				
		        DepartmentDto departmentDto = new DepartmentDto();
		        departmentDto.setDepartmentName("R&D Department");
		        departmentDto.setDepartmentCode("RD001");
		        departmentDto.setDepartmentDescription("Research and Development");
		
				
				EmployeeDto getEmployee = new EmployeeDto(
						employee.getId(),employee.getFirstName(),
						employee.getLastName(),employee.getEmail(),
						employee.getDepartmentCode(),
						employee.getDepartmentCode());
				
				APIResponseDto apiResponseDto = new APIResponseDto();
				apiResponseDto.setDepartmentDto(departmentDto);
				apiResponseDto.setEmployeeDto(getEmployee);
				
				return apiResponseDto;
	}
	
}
