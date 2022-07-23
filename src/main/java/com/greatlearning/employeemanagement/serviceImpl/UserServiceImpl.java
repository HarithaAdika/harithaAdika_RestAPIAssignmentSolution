package com.greatlearning.employeemanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.entity.Role;
import com.greatlearning.employeemanagement.entity.User;
import com.greatlearning.employeemanagement.repository.RoleRepository;
import com.greatlearning.employeemanagement.repository.UserRepository;
import com.greatlearning.employeemanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@Override
	public User saveNewUser(User user) {
		List<Role> roles =user.getRoles();
		if(roles != null) {
			for(Role role : roles) {
				roleRepository.saveAndFlush(role);
			}
		}
		return userRepository.saveAndFlush(user);
		
	}
	
	
	

}
