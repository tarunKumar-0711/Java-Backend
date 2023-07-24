package com.applictaion.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddEmployee {
	
	
	private String name;
	private String password;
	private String confirmPassword;
	private String email;
	
}
