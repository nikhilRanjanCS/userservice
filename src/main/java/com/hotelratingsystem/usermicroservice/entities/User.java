package com.hotelratingsystem.usermicroservice.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String email;
	
	@Transient
	private List<Rating> ratingsByUser;
	
	

	public User(int id, String name, String email, List<Rating> ratingsByUser) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.ratingsByUser = ratingsByUser;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Rating> getRatingsByUser() {
		return ratingsByUser;
	}

	public void setRatingsByUser(List<Rating> ratingsByUser) {
		this.ratingsByUser = ratingsByUser;
	}
}

