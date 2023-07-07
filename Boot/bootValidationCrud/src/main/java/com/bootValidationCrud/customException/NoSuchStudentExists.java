package com.bootValidationCrud.customException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NoSuchStudentExists extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
	
}
