package com.greatlearning.employeemanagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.repository.EmployeeRepository;
import com.greatlearning.employeemanagement.service.EmployeeReadService;

@Service
public class EmployeeReadServiceImpl implements EmployeeReadService {
	@Autowired
	EmployeeRepository readRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return readRepository.findAll();
	}

	@Override
	public List<Employee> getEmployeesByFirstName(String firstName) {
		Employee employeeWithFirstName = new Employee();
		employeeWithFirstName.setFirstName(firstName);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "lastName", "email");
		Example<Employee> empExample = Example.of(employeeWithFirstName, exampleMatcher);
		return readRepository.findAll(empExample);
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		return readRepository.findById(id);
	}

	// custom sorted by firstname
	@Override
	public List<Employee> getEmployeesCustomSortedByFirstName(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "firstName"));
	}

	// By default sorting to Asc
	@Override
	public List<Employee> getEmployeesSortedByFirstName() {
		return readRepository.findAll(Sort.by("firstName"));

	}

}
