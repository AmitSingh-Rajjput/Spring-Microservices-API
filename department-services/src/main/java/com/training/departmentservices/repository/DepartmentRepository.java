package com.training.departmentservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.departmentservices.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByDepartmentCode(String departmentCode);
}
