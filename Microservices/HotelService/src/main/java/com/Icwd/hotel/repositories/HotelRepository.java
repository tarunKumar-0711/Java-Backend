package com.Icwd.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Icwd.hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,String>{
	

}
