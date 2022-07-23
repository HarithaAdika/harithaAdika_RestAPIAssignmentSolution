package com.greatlearning.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
//this is used for logger functionality
@Slf4j 
public class EmployeesController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/list")
	public String employeesList() {
		log.info("Request to fetch existing Employee details");
		return "just checking";
		
	}

}
