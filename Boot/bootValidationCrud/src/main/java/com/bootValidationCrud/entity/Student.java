package com.bootValidationCrud.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="Student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "Name cannot be null or empty")
	private String name;
	
	@NotBlank(message = "Roll No cannot be null or empty")
	@Pattern(regexp = "\\d+", message="Roll can contain digits only")
	@Column(name = "rollNo")
	private String rollNo;
	
	@Email(message = "Email cannot be null or empty")
	@Pattern(regexp = ".+@gmail\\.com$", message = "Email must be a Gmail address")
	private String email;
	
	@NotBlank(message = "State cannot be Empty")
	private String state;
	
	
	private String sports;
	private String subject;
	
	@Embedded
	Address address;
	
	

}
