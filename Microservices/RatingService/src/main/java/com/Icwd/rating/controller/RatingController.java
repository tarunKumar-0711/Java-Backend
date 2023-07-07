package com.Icwd.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Icwd.rating.entities.Rating;
import com.Icwd.rating.exception.ResourceNotFoundException;
import com.Icwd.rating.service.RatingServiceInterface;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingServiceInterface ratingServiceInterface;

	@PostMapping("/saveRating")
	public void saveRating(@RequestBody Rating rating) {

		ratingServiceInterface.create(rating);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Rating>> getAllRatings() {
		List<Rating> ratingsList = ratingServiceInterface.getAll();
		if (ratingsList.size() == 0 || ratingsList == null) {
			throw new ResourceNotFoundException();
		}

		return new ResponseEntity<List<Rating>>(ratingsList, HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Rating> getRatingById(@PathVariable String id) {

		Rating rating = ratingServiceInterface.getRating(id);
		if (rating == null)
			throw new ResourceNotFoundException();

		return new ResponseEntity<Rating>(rating, HttpStatus.OK);
	}

	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingForHotel(@PathVariable("hotelId") String hotelId) {

		List<Rating> listRating = ratingServiceInterface.findByHotelId(hotelId);
		if (listRating.size() == 0 || listRating.isEmpty()) {
			throw new ResourceNotFoundException();
		}

		return new ResponseEntity<List<Rating>>(listRating, HttpStatus.OK);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingForUser(@PathVariable("userId") String userId) {

		List<Rating> listRating = ratingServiceInterface.findByUserId(userId);
		if (listRating.size() == 0 || listRating.isEmpty()) {
			throw new ResourceNotFoundException();
		}

		return new ResponseEntity<List<Rating>>(listRating, HttpStatus.OK);
	}

}
