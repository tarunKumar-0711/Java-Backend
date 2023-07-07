package com.Icwd.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Icwd.hotel.payload.ApiResponse;



@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	 public ResponseEntity<ApiResponse> handlerResouceNotFoundException(ResourceNotFoundException e){
		String message = e.getMessage();
		ApiResponse response =  ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	 }

	
}
