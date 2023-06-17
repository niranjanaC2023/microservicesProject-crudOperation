package com.eidiko.niranjana.service;

import java.util.List;

import com.eidiko.niranjana.entity.Rating;

public interface IRatingService 
{
	//save rating data into DB
	Rating saveIntoDB(Rating rating);
	
	//get All rating
	List<Rating> getAllRating();
	
	
	//get single rating by using user ID
	List<Rating> getRatingByUserId(String userId);
	
	
	//get single rating by using hotel ID
	List<Rating> getRatingByHotelId(String userId);

}
