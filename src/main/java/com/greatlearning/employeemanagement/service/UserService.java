package com.greatlearning.employeemanagement.service;

import java.util.List;

import com.greatlearning.employeemanagement.entity.User;

public interface UserService {

	List<User> getAllUsers();

	User saveNewUser(User user);

}