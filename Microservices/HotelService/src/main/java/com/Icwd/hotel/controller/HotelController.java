package com.Icwd.hotel.controller;

import java.lang.module.ResolutionException;
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

import com.Icwd.hotel.entities.Hotel;
import com.Icwd.hotel.exceptions.ResourceNotFoundException;
import com.Icwd.hotel.services.HotelServices;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired private HotelServices hotelServices;
	
	@PostMapping("/save")
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
		Hotel hotel1 = hotelServices.create(hotel);
		
		if(hotel==null) {
			throw new ResourceNotFoundException();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(hotel);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> listHotels = hotelServices.getAllHotels();
		
		if(listHotels.size()==0 || listHotels.isEmpty()) {
			System.out.println("In getAll exception Block");
			throw new ResolutionException();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(listHotels);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String id){
		Hotel  hotel = hotelServices.getHotel(id);
		
		if(hotel==null) {
			throw new ResourceNotFoundException();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(hotel);
	}
}
