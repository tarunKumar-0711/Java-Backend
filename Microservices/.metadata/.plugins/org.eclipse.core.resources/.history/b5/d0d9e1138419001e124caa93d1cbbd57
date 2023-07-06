package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		String randomUseridString = UUID.randomUUID().toString();
		user.setUserId(randomUseridString);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAlluser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent())
		{
			return user.get();
		}
//		else {
//			return user.orElseThrow( () -> ResourceNotFoundException());
//		}
		return null;
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User update(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
