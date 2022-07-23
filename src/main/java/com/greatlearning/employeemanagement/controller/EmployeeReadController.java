package com.greatlearning.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.service.EmployeeReadService;

@RestController
@RequestMapping("/employees")
public class EmployeeReadController {

	@Autowired
	EmployeeReadService readService;

	@GetMapping("/list")
	public List<Employee> getAllEmployees() {
		return readService.getAllEmployees();
	}

	@GetMapping("/getEmployeesByFirstName")
	public List<Employee> getEmployeesByFirstName(String firstName) {
		return readService.getEmployeesByFirstName(firstName);
	}

	@GetMapping("/getEmployeeById")
	public Optional<Employee> getEmployeeById(int id) {
		return readService.getEmployeeById(id);
	}

	@GetMapping("/sort")
	public List<Employee> getEmployeesCustomSortedByFirstName(Direction order) {
		return readService.getEmployeesCustomSortedByFirstName(order);
	}

	@GetMapping("/defaultsort")
	public List<Employee> getEmployeesSortedByFirstName() {
		return readService.getEmployeesSortedByFirstName();
	}
}
