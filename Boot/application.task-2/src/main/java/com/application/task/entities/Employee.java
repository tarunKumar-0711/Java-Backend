package com.application.task.entities;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

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
@Entity
public class Employee {
	
	
	@Id
	private String email;
	
	
	@NotEmpty
	private String password;
	
	
	@NotEmpty
	private String name;
	 
	
	
	private LocalTime local_time;
	
	private Integer otp;
	
}
