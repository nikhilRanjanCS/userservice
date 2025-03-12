package com.hotelratingsystem.usermicroservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelratingsystem.usermicroservice.entities.User;


public interface UserRepo extends JpaRepository<User, Integer>{
	
}
