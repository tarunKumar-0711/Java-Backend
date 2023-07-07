package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<User> creatUser(@RequestBody User user){
		User user1 = userService.saveUser(user);
		//return ResponseEntity<User>.status(HttpStatus.CREATED).body(user1);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	
	@GetMapping("/userid=/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable("userId") String userId){
		User user = userService.getUser(userId);
		
		return ResponseEntity.ok(user);
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> list = userService.getAlluser();
		if(list.size()==0 || list.isEmpty())
			throw new ResourceNotFoundException();
		return ResponseEntity.ok(list);
	}
}
