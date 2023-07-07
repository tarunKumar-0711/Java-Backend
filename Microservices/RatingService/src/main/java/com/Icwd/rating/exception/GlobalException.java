package com.Icwd.rating.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleResourceNotFoundException(ResourceNotFoundException e){
		Map<String,Object> map = new HashMap<>();
		map.put("message", e.getMessage());
		map.put("success", false);
		map.put("status",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
	}
}
