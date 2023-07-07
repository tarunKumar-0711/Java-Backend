package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Hotel {
	

	private String id;
	private String name;
	private String location;
}
