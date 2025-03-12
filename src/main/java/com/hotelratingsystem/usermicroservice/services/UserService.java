package com.hotelratingsystem.usermicroservice.services;

import java.util.List;

import com.hotelratingsystem.usermicroservice.entities.User;



public interface UserService {
	
	public User saveUser(User user);
	
	public List<User> getAllUsers ();
	
	public User getUser(int userId);
}
