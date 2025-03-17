package com.hotelratingsystem.usermicroservice.externalservices;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.hotelratingsystem.usermicroservice.entities.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
	
	@GetMapping("/api/hotel/getall")
	List<Hotel> getHotels();
}
