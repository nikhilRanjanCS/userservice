package com.hotelratingsystem.usermicroservice.entities;

public class Hotel {
	
	private String id;
	private String name;
	private String location;
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hotel(String id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}

