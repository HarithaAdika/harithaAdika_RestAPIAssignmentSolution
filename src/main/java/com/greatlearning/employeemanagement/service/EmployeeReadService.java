package com.greatlearning.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.employeemanagement.entity.Employee;

public interface EmployeeReadService {

	List<Employee> getAllEmployees();

	List<Employee> getEmployeesByFirstName(String firstName);

	Optional<Employee> getEmployeeById(int id);

	// custom sorted by firstname
	List<Employee> getEmployeesCustomSortedByFirstName(Direction direction);

	// By default sorting to Asc
	List<Employee> getEmployeesSortedByFirstName();

}