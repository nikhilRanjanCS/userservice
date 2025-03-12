package com.hotelratingsystem.usermicroservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelratingsystem.usermicroservice.entities.User;
import com.hotelratingsystem.usermicroservice.exception.ResourceNotFoundException;
import com.hotelratingsystem.usermicroservice.repos.UserRepo;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUser(int userId){
		// TODO Auto-generated method stub
		return userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user id not found"));
	}

}
