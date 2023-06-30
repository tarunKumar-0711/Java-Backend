package com.bootValidationCrud.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
	@NotBlank
	private String streetNo;
	
	@NotBlank
	private String Area;
	
	@NotBlank
	private String city;
}
