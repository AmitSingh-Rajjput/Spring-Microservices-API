package com.training.employeeservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.employeeservices.dto.APIResponseDto;
import com.training.employeeservices.dto.EmployeeDto;
import com.training.employeeservices.services.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> savedEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
		
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping("{emp_id}")
	public ResponseEntity<APIResponseDto> getemployeebyId(@PathVariable("emp_id") Long id){
		APIResponseDto apiResponseDto = employeeService.getEmployeeById(id);
		return new ResponseEntity<>(apiResponseDto,HttpStatus.FOUND);
	}
	

}
