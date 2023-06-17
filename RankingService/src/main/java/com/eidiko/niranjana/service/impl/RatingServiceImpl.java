package com.eidiko.niranjana.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eidiko.niranjana.entity.Rating;
import com.eidiko.niranjana.repo.IRatingRepo;
import com.eidiko.niranjana.service.IRatingService;

@Service
public class RatingServiceImpl implements IRatingService 
{
	@Autowired
	private IRatingRepo repo;

	@Override
	public Rating saveIntoDB(Rating rating) 
	{
		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		return repo.save(rating);
	}

	@Override
	public List<Rating> getAllRating() 
	{
		return repo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return repo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String userId) {
		return repo.findByHotelId(userId);
	}

	

}
