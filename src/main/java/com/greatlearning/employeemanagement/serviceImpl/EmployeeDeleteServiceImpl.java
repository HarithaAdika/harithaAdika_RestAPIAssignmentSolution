package com.greatlearning.employeemanagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.repository.EmployeeRepository;
import com.greatlearning.employeemanagement.service.EmployeeDeleteService;

@Service
public class EmployeeDeleteServiceImpl implements EmployeeDeleteService {
	@Autowired
	EmployeeRepository deleteRepository;

	@Override
	public String deleteEmployeeById(int id) {
		deleteRepository.deleteById(id);
		return "Deleted Employee of Id:" + id + " Successfully";
	}

}
