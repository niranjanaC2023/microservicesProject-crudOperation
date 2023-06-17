package com.eidiko.niranjana.service;

import java.util.List;

import com.eidiko.niranjana.entity.User;


public interface IUserService 
{
	//save rating data into DB
		User saveIntoDB(User user);
		
		//get All rating
		List<User> getAllUserData();
		
		
		//get single user by using user ID
		User getSingleUser(String userId);
		
}
