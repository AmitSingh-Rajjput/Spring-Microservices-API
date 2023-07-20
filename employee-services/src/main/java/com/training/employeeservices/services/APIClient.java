package com.training.employeeservices.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.employeeservices.dto.DepartmentDto;


@FeignClient(name="DEPARTMENT-SERVICE")
public interface APIClient {
    // Build get department rest api
    @GetMapping("api/departments/{department-code}")
    ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode);
}
