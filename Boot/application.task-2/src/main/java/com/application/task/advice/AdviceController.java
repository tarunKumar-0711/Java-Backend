package com.application.task.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.application.task.customException.EmployeeException;
import com.application.task.customException.PasswordException;


@RestController
public class AdviceController {
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<String> handleEmployeeException(EmployeeException e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(PasswordException.class)
	public ResponseEntity<String> handlePasswordException(PasswordException e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		 BindingResult bindingResult = e.getBindingResult();

		    Map<String, String> resp = new HashMap<>();

		    for (FieldError error : bindingResult.getFieldErrors()) {
		        String fieldName = error.getField();
		        String message = error.getDefaultMessage();
		        resp.put(fieldName, message);
		    }

		
		  
		return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
		
	}
}
