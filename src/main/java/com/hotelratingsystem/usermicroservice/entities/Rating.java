package com.hotelratingsystem.usermicroservice.entities;

public class Rating {
	
	
	
	private String ratingId;
	
	
	private int userId;
	
	
	private String hotelId;
	
	
	private int rating;


	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Rating(String ratingId, int userId, String hotelId, int rating) {
		super();
		this.ratingId = ratingId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.rating = rating;
	}


	public String getRatingId() {
		return ratingId;
	}


	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getHotelId() {
		return hotelId;
	}


	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}

	
	
}

