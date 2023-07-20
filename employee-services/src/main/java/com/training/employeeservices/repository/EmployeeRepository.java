package com.training.employeeservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.employeeservices.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
