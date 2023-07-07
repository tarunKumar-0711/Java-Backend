package com.Icwd.hotel.services;

import java.util.List;

import com.Icwd.hotel.entities.Hotel;

public interface HotelServices {
	Hotel create(Hotel hotel);
	List<Hotel> getAllHotels();
	Hotel getHotel(String id);
	
}
