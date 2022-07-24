package com.greatlearning.employeemanagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.repository.EmployeeRepository;
import com.greatlearning.employeemanagement.service.EmployeeCreateService;

@Service
public class EmployeeCreateServiceImpl implements EmployeeCreateService {
	
	@Autowired
	EmployeeRepository	employeeRepository;
	
	@Override
	public String addNewEmployee(List<Employee> employee) {
		employeeRepository.saveAllAndFlush(employee);
		return "New Employee saved successfully";
		
	}
	
	@Override
	public String addMultipleNewEmployees(List<Employee> employees) {
		employeeRepository.saveAllAndFlush(employees);
		return "Successfully added multiple Employees at once";
	}

	@Override
	public String editEmployeeById(int employeeId, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public String editEmployeeById(int employeeId, Employee employee) {
//		Employee updateEmp = new Employee();
//		if(employeeRepository.existsById(employeeId)) {
//			
//			updateEmp.setFirstName(employee.getFirstName());
//			updateEmp.setLastName(employee.getLastName());
//			updateEmp.setEmail(employee.getEmail());
//			return addNewEmployee(updateEmp);
//		}
//		else {
//			return "Employee not found";
//		}
//		
//	}
	

}
