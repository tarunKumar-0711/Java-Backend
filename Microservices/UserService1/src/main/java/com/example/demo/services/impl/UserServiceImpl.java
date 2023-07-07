package com.example.demo.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.Hotel;
import com.example.demo.entities.Rating;
import com.example.demo.entities.User;
import com.example.demo.external.services.HotelService;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	//private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private RestTemplate restTemplate;
	
	   @Autowired
	    private HotelService hotelService;

	@Override
	public User saveUser(User user) {
		String randomUseridString = UUID.randomUUID().toString();
		user.setUserId(randomUseridString);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAlluser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			System.out.println("Hello");
			
			Rating [] ratingOfUser = restTemplate
					.getForObject("http://RATING-SERVICE/ratings/users/" + user.get().getUserId(), Rating[].class);
//			List<Rating> ratingOfUser = restTemplate.exchange(
//					"localhost:8082/ratings/users/e65c6dc9-4ac2-402d-9961-385a42036401",
//					HttpMethod.GET,
//					new HttpEntity<>(null),
//					new ParameterizedTypeReference<List<Rating>>() {
//					});
			//logger.info("{} ", ratingOfUser);
			
			List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
			
			List<Rating> ratingList = ratings.stream().map(rating -> {
//				ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity
//						("http://HOTEL-SERVICE/hotels/getById/"+ rating.getHotelId(), Hotel.class);
//				Hotel hotel = hotelEntity.getBody();
				
				Hotel hotel = hotelService.getHotel(rating.getHotelId());
				rating.setHotel(hotel);
				
				return rating;
			}).collect(Collectors.toList());
			user.get().setRatings(ratingList);
			return user.get();
		}
//		else {
//			return user.orElseThrow( () -> ResourceNotFoundException());
//		}

		return null;
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public User update(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
