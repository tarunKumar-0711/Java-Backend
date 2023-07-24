package com.applictaion.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UpdateEmployee {
	
	private Integer otp;
	
	private String email;
	
	private String password;
	
	private String confirmPassword;
	
}
