package com.hotelratingsystem.usermicroservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotelratingsystem.usermicroservice.entities.Hotel;
import com.hotelratingsystem.usermicroservice.entities.Rating;
import com.hotelratingsystem.usermicroservice.entities.User;
import com.hotelratingsystem.usermicroservice.exception.ResourceNotFoundException;
import com.hotelratingsystem.usermicroservice.externalservices.HotelService;
import com.hotelratingsystem.usermicroservice.repos.UserRepo;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userRepo.findAll();
		
		ResponseEntity<List<Rating>> response = restTemplate.exchange(
			    "http://localhost:8082/api/rating/getall",
			    HttpMethod.GET,
			    null,
			    new ParameterizedTypeReference<List<Rating>>() {}
			);

		List<Rating> ratings = response.getBody();
		for(User user: users) {
			List<Rating> userRatings = new ArrayList<>();
			ratings.parallelStream().forEach((rating)->{
				
				if(rating.getUserId()==user.getId()) {
					userRatings.add(rating);
				}
			});
			user.setRatingsByUser(userRatings);
		}
		
		return  users;
	}

	@Override
	public User getUser(int userId){
		// TODO Auto-generated method stub
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user id not found"));
		
		ResponseEntity<List<Rating>> response = restTemplate.exchange(
			    "http://RATING-SERVICE/api/rating/getratings/user/{userId}",
			    HttpMethod.GET,
			    null,
			    new ParameterizedTypeReference<List<Rating>>() {},
			    userId
			);
		List<Rating> userRatings = response.getBody();
		
//		ResponseEntity<List<Hotel>> hotelServiceResponse = restTemplate.exchange(
//			    "http://HOTEL-SERVICE/api/hotel/getall",
//			    HttpMethod.GET,
//			    null,
//			    new ParameterizedTypeReference<List<Hotel>>() {}
//			);
		List<Hotel> hotels = hotelService.getHotels();
		
		
		
		for(Rating rating:userRatings) {
			hotels.stream().forEach((hotel)->{
				if(UUID.fromString(rating.getHotelId()).equals(UUID.fromString(hotel.getId()))) {
					rating.setHotel(hotel);
				}
			});
		}
		
		user.setRatingsByUser(userRatings);
		return user;
	}

}
