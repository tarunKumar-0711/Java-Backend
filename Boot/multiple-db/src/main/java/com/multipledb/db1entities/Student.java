package com.multipledb.db1entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student {
	
	@Id
	private Integer id;
	
	private String name;
}
