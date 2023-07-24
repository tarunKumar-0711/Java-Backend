package com.applictaion.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.applictaion.task.dto.AddEmployee;
import com.applictaion.task.dto.UpdateEmployee;
import com.applictaion.task.services.ServiceInterface;

@RestController
@RequestMapping
public class MainController {
	
	@Autowired
	private ServiceInterface serviceInterface;
	
	@PostMapping("/addEmployee/")
	public ResponseEntity<Object> addEmployee(@RequestBody AddEmployee employee){
		serviceInterface.addEmployee(employee);
		return new ResponseEntity<>("Employee Added", HttpStatus.OK);
	}
	
	@PostMapping("/reset/{email}")
	public ResponseEntity<Object> resetPassword(@PathVariable String email){
		serviceInterface.reset(email);
		return new ResponseEntity<>("Otp sent", HttpStatus.OK);
	}
	
	@PostMapping("/update/")
	public ResponseEntity<Object> updatePassword(@RequestBody UpdateEmployee employee){
		serviceInterface.updateEmployee(employee);
		return new ResponseEntity<>("Updated",HttpStatus.OK);
	}
}
