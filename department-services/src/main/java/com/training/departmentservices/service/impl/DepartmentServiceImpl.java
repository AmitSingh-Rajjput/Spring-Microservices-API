package com.training.departmentservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.departmentservices.dto.DepartmentDto;
import com.training.departmentservices.entity.Department;
import com.training.departmentservices.mapper.DepartmentMapper;
import com.training.departmentservices.repository.DepartmentRepository;
import com.training.departmentservices.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		
		//Convert department dto to department jpa
		Department department = DepartmentMapper.mapToDepartment(departmentDto);
		
//		Department department = new Department(
//				departmentDto.getId(),
//				departmentDto.getDepartmentName(),
//				departmentDto.getDepartmentDescription(),
//				departmentDto.getDepartmentCode());
//		
		Department savedDepartment = departmentRepository.save(department);
		
		DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);
//		DepartmentDto savedDepartmentDto = new DepartmentDto(
//				savedDepartment.getId(),
//				savedDepartment.getDepartmentName(),
//				savedDepartment.getDepartmentDescription(),
//				savedDepartment.getDepartmentCode());
		
		return savedDepartmentDto;
	}

	
	@Override
	public DepartmentDto getDepartmentByCode(String code) {
		
		Department department = departmentRepository.findByDepartmentCode(code);
		
		DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
		
//		DepartmentDto departmentDto = new DepartmentDto(
//				department.getId(),
//				department.getDepartmentName(),
//				department.getDepartmentDescription(),
//				department.getDepartmentCode());
//		
		return departmentDto;
	}
	

}
