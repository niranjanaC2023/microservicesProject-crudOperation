package com.eidiko.niranjana.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.eidiko.niranjana.entity.Rating;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface IRatingService 
{
	@PostMapping("/ratings/dataSave")
	public Rating saveIntoDB(Rating values);
	
	@PutMapping("/ratings/{ratingId}")
	public Rating updateRating(@PathVariable String ratingId, Rating rating);
	
	@DeleteMapping("/ratings/{ratingId}")
	public void deleteRating(@PathVariable String ratingId);

}
