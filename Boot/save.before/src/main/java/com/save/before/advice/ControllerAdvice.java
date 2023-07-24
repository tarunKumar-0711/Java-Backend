package com.save.before.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.save.before.customException.PageException;

@RestController
public class ControllerAdvice {
	
	@ExceptionHandler(PageException.class)
	public ResponseEntity<String> handlePageException(PageException e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
