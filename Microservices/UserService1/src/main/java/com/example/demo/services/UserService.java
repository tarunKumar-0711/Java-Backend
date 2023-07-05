package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.User;

public interface UserService {
	public User saveUser(User user);
	List<User> getAlluser();
	User getUser(String userId);
	void deleteUser(String userId);
	User update(String userId);
	
}
