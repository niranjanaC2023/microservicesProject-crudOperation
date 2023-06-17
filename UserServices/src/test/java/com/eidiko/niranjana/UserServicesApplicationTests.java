package com.eidiko.niranjana;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eidiko.niranjana.entity.Rating;
import com.eidiko.niranjana.feignclient.IRatingService;

@SpringBootTest
class UserServicesApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private IRatingService ratingService;

	//@Test
	void createRating()
	{
		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("This is created using feign client").build();
		Rating savedRating = ratingService.saveIntoDB(rating);
		System.out.println("new rating saved in to db");
	}
	
	@Test
	void updateRating()
	{
		String ratingId = "78151c4f-272a-4dfe-9f8c-b67a47530291";
		Rating rating = Rating.builder().rating(10).userId("1234").hotelId("5678").feedback("update the rating data using feign client").build();
		Rating savedRating = ratingService.updateRating(ratingId,rating);
		System.out.println("rating has updated");
	}
}
