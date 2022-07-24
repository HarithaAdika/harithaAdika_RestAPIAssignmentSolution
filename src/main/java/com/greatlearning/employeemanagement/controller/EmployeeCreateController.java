package com.greatlearning.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.service.EmployeeCreateService;

@RestController
@RequestMapping("/employees")
public class EmployeeCreateController {

	@Autowired
	EmployeeCreateService createService;

	@PostMapping(value = "/addSingleEmployee")
	public String addSingleEmployee(@RequestBody List<Employee> employee) {
		return createService.addNewEmployee(employee);
	}

	@PostMapping("/addMultipleEmployee")
	public String addMultipleEmployee(@RequestBody List<Employee> employees) {
		return createService.addMultipleNewEmployees(employees);
	}

	@PutMapping("/updateEmployeeById")
	public String editEmployeeById(int id, @RequestBody Employee employee) {
		String editedEmployee = createService.editEmployeeById(id, employee);
		return editedEmployee;
	}

}
