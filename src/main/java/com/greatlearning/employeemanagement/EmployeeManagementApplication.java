package com.greatlearning.employeemanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.service.EmployeeCreateService;
import com.greatlearning.employeemanagement.service.EmployeeDeleteService;
import com.greatlearning.employeemanagement.service.EmployeeReadService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeeManagementApplication implements CommandLineRunner {

	@Autowired
	EmployeeReadService employeeReadServiceImpl;

	@Autowired
	EmployeeDeleteService employeeDeleteServiceImpl;

	@Autowired
	EmployeeCreateService employeeCreateServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		employeeReadServiceImplMethodsExecution();

//		employeeDeleteServiceImplMethodsExecution();

//		employeeCreateServiceImplMethodsExecution();
	}

	private void employeeCreateServiceImplMethodsExecution() {
		log.info("Adding Single Employee details ->{}", employeeCreateServiceImpl.addNewEmployee((Employee) Employee
				.builder().id(11).firstName("Sharan").lastName("Sharma").email("sharansharma@gmai.com").build()));

		List<Employee> employees = new ArrayList<>();
		employees.add(Employee.builder().firstName("Shruthi").lastName("Palem").email("shruthiP@test.com").build());
		employees.add(Employee.builder().firstName("Arthi").lastName("Palem").email("ArthiP@test.com").build());
		employees.add(Employee.builder().firstName("Ramya").lastName("Gaja").email("ramya@test.com").build());
		log.info("Adding multiple New employees ->{}", employeeCreateServiceImpl.addMultipleNewEmployees(employees));
	}

	private void employeeDeleteServiceImplMethodsExecution() {
		log.info("Deleting Employee with Id: ->{}", employeeDeleteServiceImpl.deleteEmployeeById(4));
	}

	private void employeeReadServiceImplMethodsExecution() {
		log.info("Fetch all Employees ->{}", employeeReadServiceImpl.getAllEmployees());
		log.info("Fetch all the employees with the given First Name ->{}",
				employeeReadServiceImpl.getEmployeesByFirstName("Haritha"));

		int id = 16;
		Optional<Employee> optionalEmployee = employeeReadServiceImpl.getEmployeeById(id);
		if (optionalEmployee.isPresent()) {
			log.info("Fetach Employee by id ->{}", optionalEmployee.get());
		} else {
			log.info("No matching Employee with the given id:" + id + "is present");
		}

		log.info("Employees firstname custom sorted by Ascending :->{}",
				employeeReadServiceImpl.getEmployeesCustomSortedByFirstName(Direction.ASC));
		log.info("Employees firstname custom sorted by Descending :->{}",
				employeeReadServiceImpl.getEmployeesCustomSortedByFirstName(Direction.DESC));

		log.info("Employees default sorted by FirstName to Ascending: ->{}",
				employeeReadServiceImpl.getEmployeesSortedByFirstName());
	}

}
