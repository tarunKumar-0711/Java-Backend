package com.Icwd.rating.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Icwd.rating.entities.Rating;
import com.Icwd.rating.exception.ResourceNotFoundException;
import com.Icwd.rating.repository.RatingRepository;

@Service
public class RatingService implements RatingServiceInterface{
	
	@Autowired
	private RatingRepository ratingRepository;
	
	
	public Rating create(Rating rating) {
		String randomId = UUID.randomUUID().toString();
		rating.setRatingID(randomId);
		Rating r = ratingRepository.save(rating);
		
		if(r==null) {
			throw new ResourceNotFoundException();
		}
		
		return r;
		
	}
	
	public List<Rating>  getAll(){
		List<Rating> ratingsList = ratingRepository.findAll();
		
		if(ratingsList.size()== 0 || ratingsList==null) {
			throw new ResourceNotFoundException();
		}
		
		return ratingsList;
		
	}
	
	public Rating getRating(String id) {
		Optional<Rating> rating = ratingRepository.findById(id);
		if(rating==null) {
			throw new ResourceNotFoundException();
		}
		
		return rating.get();
	}

	@Override
	public List<Rating> findByHotelId(String id) {
		
		List<Rating> ratingList = ratingRepository.findByHotelId(id);
		if(ratingList.size()==0 || ratingList.isEmpty()) {
			throw new ResourceNotFoundException();
		}
		
		return ratingList;
	}

	@Override
	public List<Rating> findByUserId(String id) {
		List<Rating> ratingList = ratingRepository.findByUserId(id);
		if(ratingList.size()==0 || ratingList.isEmpty()) {
			throw new ResourceNotFoundException();
		}
		
		return ratingList;
	}
}
