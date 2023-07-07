package com.example.demo.external.services;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Rating;


@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {


   

    @PostMapping("/ratings/users/")
    public ResponseEntity<Rating> createRating(Rating values);


   
}