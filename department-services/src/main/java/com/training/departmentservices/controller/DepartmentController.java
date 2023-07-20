package com.training.departmentservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.departmentservices.dto.DepartmentDto;
import com.training.departmentservices.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
		name = "Department Service - Departement Controller",
        description="Departement Controller Exposes REST API for Departement Service")
@RestController
@RequestMapping("api/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	
	@Operation(
			summary="Save Department REST API",
			description="Save Department REST API is used to save departement object in database")
	@ApiResponse(
			responseCode="201",
			description="HTTP Status 201 Created")
	@PostMapping
	public ResponseEntity<DepartmentDto> savedDepartment(@RequestBody DepartmentDto departmentDto){
		DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartment,HttpStatus.CREATED);
	}
	
	
	@Operation(
			summary="Get Department REST API",
			description="Get Department REST API is used to get departement object from database")
	@ApiResponse(
			responseCode="200",
			description="HTTP Status 200 Success")
	
	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
		DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
		return new ResponseEntity<>(departmentDto,HttpStatus.FOUND);
	}

}
