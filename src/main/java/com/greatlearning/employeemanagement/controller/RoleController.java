package com.greatlearning.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.entity.Role;
import com.greatlearning.employeemanagement.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	RoleService roleService;

	@GetMapping("/list")
	public List<Role> getRoles() {
		return roleService.getAllRoles();
	}

	@PostMapping("/addRole")
	public String addNewRole(@RequestBody List<Role> role) {
		return roleService.saveNewRole(role);
		
	}

}
