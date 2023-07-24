package com.application.task.customException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
public class PasswordException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String message;
	
	
	public PasswordException(String message) {
		super(message);
	}
	
}
