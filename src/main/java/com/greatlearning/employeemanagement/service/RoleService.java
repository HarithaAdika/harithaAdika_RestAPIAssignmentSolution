package com.greatlearning.employeemanagement.service;

import java.util.List;

import com.greatlearning.employeemanagement.entity.Role;

public interface RoleService {

	List<Role> getAllRoles();

	String saveNewRole(List<Role> role);

}