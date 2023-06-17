package com.eidiko.niranjana.service;

import java.util.List;

import com.eidiko.niranjana.entity.Hotel;

public interface IHotelService {

	
	//data save into hotel
	Hotel saveHotelData(Hotel hotel);
	
	//get all Hotel Data
	List<Hotel> getAllHotelData();
	
	
	//get hotel data based on ID
	Hotel getSingleHHotelData(String hotelId);
}
