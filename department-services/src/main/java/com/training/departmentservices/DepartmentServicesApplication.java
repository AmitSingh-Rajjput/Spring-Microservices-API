package com.training.departmentservices;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
		info= @Info(
				title="Department Service REST APIs",
				description="Department Service REST APIs Documentation",
				version="v1.0",
				contact = @Contact(
						name="Amit Singh",
						email="amit277.iimt@gmail.com"
						),
				license = @License(
						name="Apache 2.0",
						url="www.google.com")
				),
		externalDocs = @ExternalDocumentation(
				description="Departement Service Doc"))

@SpringBootApplication
public class DepartmentServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServicesApplication.class, args);
	}

}
