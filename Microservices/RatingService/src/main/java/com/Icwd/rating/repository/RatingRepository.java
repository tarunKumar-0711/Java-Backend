package com.Icwd.rating.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Icwd.rating.entities.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String>{
	
	@Query(value = " SELECT * FROM micro_ratings WHERE user_id = :uid", nativeQuery = true)
//	@Query(value = "SELECT r FROM micro_ratings r WHERE r.user_id = :uid", nativeQuery = true)
	List<Rating> findByUserId(@Param("uid") String uid);
	
//	@Query(value = "SELECT r FROM micro_ratings r WHERE r.hotel_id = :hid", nativeQuery = true)
	@Query("SELECT r FROM microRat r WHERE r.hotelId = :hid")
	List<Rating> findByHotelId(@Param("hid") String hid);
}
