package com.eidiko.niranjana.controller;

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

import com.eidiko.niranjana.entity.Rating;
import com.eidiko.niranjana.service.IRatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController 
{
	@Autowired
	private IRatingService service;
	
	@PostMapping("/dataSave")
	public ResponseEntity<Rating> saveIntoDB(@RequestBody Rating rating)
	{
		Rating data = service.saveIntoDB(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(data);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Rating>> getAllRatings()
	{
		List<Rating> data = service.getAllRating();
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}

	//get single rating by using user ID
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId( @PathVariable String userId)
	{
		List<Rating> data = service.getRatingByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
	
	//get single rating by using hotel ID
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId)
	{
		List<Rating> data = service.getRatingByHotelId(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
}
