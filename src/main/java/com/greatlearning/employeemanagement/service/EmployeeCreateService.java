package com.greatlearning.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import com.greatlearning.employeemanagement.entity.Employee;

public interface EmployeeCreateService {

	String addNewEmployee(Employee employee);

	String addMultipleNewEmployees(List<Employee> employees);

	String editEmployeeById(int employeeId, Employee employee);

}