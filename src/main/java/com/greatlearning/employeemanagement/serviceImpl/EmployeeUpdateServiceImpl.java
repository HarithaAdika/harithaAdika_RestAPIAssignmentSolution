package com.greatlearning.employeemanagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.repository.EmployeeRepository;
import com.greatlearning.employeemanagement.service.EmployeeUpdateService;

@Service
public class EmployeeUpdateServiceImpl implements EmployeeUpdateService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee updateExistingEmployeeById(int id, Employee employee) {
		Employee existingEmployee = new Employee();
		if (!employeeRepository.existsById(id)) {
			return employeeRepository.saveAndFlush(employee);
		}
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		return employeeRepository.saveAndFlush(existingEmployee);

	}

}
