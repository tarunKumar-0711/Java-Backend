package com.bootValidationCrud.Advice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bootValidationCrud.customException.EmptyListException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import com.bootValidationCrud.customException.NoSuchStudentExists;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(EmptyListException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyListException e){
		return new ResponseEntity<String>("List is Empty", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchStudentExists.class)
	public ResponseEntity<String> handleEmptyInput(NoSuchStudentExists e){
		return new ResponseEntity<String>("No Student present with given id.", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//		Map<String, String> resp = new HashMap<>();
//		BindingResult bindingResult = e.getBindingResult();
//		
//		e.getBindingResult().getAllErrors.forEach((error)->{
//			String fieldName = ((FieldError) error).getField();
//			String message = error.getDefaultMessage();
//			resp.put(fieldName,message);
//		});
		
		 BindingResult bindingResult = e.getBindingResult();

		    Map<String, String> resp = new HashMap<>();

		    for (FieldError error : bindingResult.getFieldErrors()) {
		        String fieldName = error.getField();
		        String message = error.getDefaultMessage();
		        resp.put(fieldName, message);
		    }

		
		  
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
		//return ResponseEntity.badRequest().body(resp);
	}
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleException(Exception e){
//		return new ResponseEntity<String>("No value is present in DataBase "+ e.getMessage() , HttpStatus.BAD_REQUEST);
//	}
}
