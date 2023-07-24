package com.application.task.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.task.dto.AddEmployee;
import com.application.task.dto.UpdateEmployee;
import com.application.task.services.ServiceInterface;

@RestController
@RequestMapping("/application")
public class MainController {

	@Autowired
	private ServiceInterface serviceInterface;

	static Logger logger = LogManager.getLogger(MainController.class);

	@PostMapping("/signUp")
	public ResponseEntity<Object> addEmployee(@RequestBody AddEmployee employee) {
		logger.info("Adding Employee from Controller");
		serviceInterface.addEmployee(employee);
		return new ResponseEntity<>("Employee Added", HttpStatus.OK);
	}

	@PostMapping("/forgotPassword/{email}")
	public ResponseEntity<Object> resetPassword(@PathVariable String email) {
		logger.info("Generating OTP for Employee from Controller");
		serviceInterface.reset(email);
		return new ResponseEntity<>("Otp sent", HttpStatus.OK);
	}

	@PostMapping("/updatePassword")
	public ResponseEntity<Object> updatePassword(@RequestBody UpdateEmployee employee) {
		logger.info("Updating Employee from Controller");
		serviceInterface.updateEmployee(employee);
		return new ResponseEntity<>("Updated", HttpStatus.OK);
	}
}
