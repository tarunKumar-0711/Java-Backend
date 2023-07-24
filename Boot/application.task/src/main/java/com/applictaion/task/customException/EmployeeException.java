package com.applictaion.task.customException;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
public class EmployeeException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String message;
	
	public EmployeeException(String message) {
		super(message);
	}
	
}
