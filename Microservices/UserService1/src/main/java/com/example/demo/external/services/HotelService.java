package com.example.demo.external.services;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entities.Hotel;

//import java.util.List;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotels/getById/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);

}