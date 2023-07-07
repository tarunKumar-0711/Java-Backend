package com.bootValidationCrud.customException;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CannotBeAdded extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
}
