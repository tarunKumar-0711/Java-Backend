package com.Icwd.rating.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity(name = "microRat")
@Table(name="micro_ratings")
public class Rating {
	@Id
	private String ratingID;
	
	@Column(name = "userId")
	private String userId;
	
	@Column(name="hotelId")
	private String hotelId;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="feedback")
	private String feedback;
}