package com.Icwd.hotel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter@NoArgsConstructor@AllArgsConstructor@ToString
@Entity
@Table(name = "hotelNew")
public class Hotel {

	@Id
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name ="location")
	private String location;
	
}
