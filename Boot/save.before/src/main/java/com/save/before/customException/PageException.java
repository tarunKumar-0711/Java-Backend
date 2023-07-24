package com.save.before.customException;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PageException  extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String message;
	
	public PageException(String message) {
		super(message);
	}
}
