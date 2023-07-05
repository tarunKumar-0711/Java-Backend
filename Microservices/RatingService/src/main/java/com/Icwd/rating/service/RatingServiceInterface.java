package com.Icwd.rating.service;

import java.util.List;

import com.Icwd.rating.entities.Rating;

public interface RatingServiceInterface {
	public Rating getRating(String id);
	public List<Rating>  getAll();
	public Rating create(Rating rating);
	public List<Rating> findByHotelId(String id);
	public List<Rating> findByUserId(String id);
	
}
