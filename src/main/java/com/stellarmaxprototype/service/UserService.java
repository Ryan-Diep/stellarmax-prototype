package com.stellarmaxprototype.service;

import java.util.List;

import com.stellarmaxprototype.entity.User;

public interface UserService {
	List<User> getAllUsers();
	
	User saveUser(User user);
	
	User getUserById(Long id);
	
	User updateUser(User user);
	
	void deleteUserById(Long id);
}
