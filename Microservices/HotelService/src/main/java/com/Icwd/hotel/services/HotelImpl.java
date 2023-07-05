package com.Icwd.hotel.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Icwd.hotel.entities.Hotel;
import com.Icwd.hotel.exceptions.ResourceNotFoundException;
import com.Icwd.hotel.repositories.HotelRepository;



@Service
public class HotelImpl implements HotelServices {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel create(Hotel hotel) {
		String randomUserId = UUID.randomUUID().toString();
		hotel.setId(randomUserId); 
		Hotel ho = hotelRepository.save(hotel);
		
		if(ho==null)
			throw new ResourceNotFoundException();
		
		return ho;
	}

	@Override
	public List<Hotel> getAllHotels() {
		List<Hotel> listHotels = hotelRepository.findAll();
		if(listHotels.size()==0 || listHotels.isEmpty() || listHotels==null) {
			System.out.println("Inside exception bloack of getAll in service layer");
			throw new ResourceNotFoundException();
		}
			
		
		return listHotels;
	}

	@Override
	public Hotel getHotel(String id) {
		Optional<Hotel> hotel = hotelRepository.findById(id);
		if(hotel==null)
			throw new ResourceNotFoundException();
		
		return hotel.get();
	}

}
