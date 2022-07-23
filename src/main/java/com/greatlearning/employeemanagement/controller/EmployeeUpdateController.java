package com.greatlearning.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.service.EmployeeUpdateService;

@RestController
@RequestMapping("/employees")
public class EmployeeUpdateController {
	@Autowired
	EmployeeUpdateService updateService;
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable int id,Employee employee) {
		Employee updateEmployee = updateService.updateExistingEmployeeById(id,employee) ;
		return ResponseEntity.ok().body(updateEmployee);
	}
	
	
	
	

}
