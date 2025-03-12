package com.hotelratingsystem.usermicroservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelratingsystem.usermicroservice.entities.User;
import com.hotelratingsystem.usermicroservice.services.UserService;





@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id){
		
			User user = userService.getUser(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User createdUser = userService.saveUser(user);
		return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
	}
}
