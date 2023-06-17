package com.eidiko.niranjana.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eidiko.niranjana.entity.Hotel;
import com.eidiko.niranjana.entity.Rating;
import com.eidiko.niranjana.entity.User;
import com.eidiko.niranjana.exception.ResourceNotFoundException;
import com.eidiko.niranjana.feignclient.IHotelService;
import com.eidiko.niranjana.repo.IUserRepository;
import com.eidiko.niranjana.service.IUserService;
@Service
public class UserServiceImpl implements IUserService 
{
	@Autowired
	private IUserRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private IHotelService hotelService;
	
	@Override
	public User saveIntoDB(User user) 
	{	
		String userID = UUID.randomUUID().toString();
		user.setId(userID);
		return repo.save(user);
	}

	@Override
	public List<User> getAllUserData() 
	{
		List<User> listOfRatingData = repo.findAll();
		
		//fetch rating from Rating Service using RestTemplate
		//ArrayList<Rating> ratingsDataOfUser = restTemplate.getForObject("http://localhost:6063/ratings/users/6a63eefb-f28f-463d-b2b9-d9b44e47dc17", ArrayList.class);//hardcore
		/*ArrayList<Rating> ratingsDataOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/fetchAll", ArrayList.class); //automatic
		System.out.println("List of rating data: "+ratingsDataOfUser);
		for(User user : listOfRatingData)
		{
			user.setRating(ratingsDataOfUser);
		}*/
		return listOfRatingData;
		
	}

	

	@Override
	public User getSingleUser(String userId) 
	{
		User user = repo.findById(userId).orElseThrow(()->new ResourceNotFoundException("Given Id Not Found "+userId));
		
		//********fetch rating from Rating Service using RestTemplate(USING REST-TEMPLATE)*******************
		
		//ArrayList<Rating> ratingsDataOfUser = restTemplate.getForObject("http://localhost:6063/ratings/users/6a63eefb-f28f-463d-b2b9-d9b44e47dc17", ArrayList.class);//hardcore
		
		/*ArrayList<Rating> ratingsDataOfUser = restTemplate.getForObject("http://localhost:6063/ratings/users/"+user.getId(), ArrayList.class); //automatic
		System.out.println("List of rating data: "+ratingsDataOfUser);
		user.setRating(ratingsDataOfUser);
		return user;
		*/     //working
		
		/*
		Rating[] ratingsDataOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getId(), Rating[].class);
		System.out.println("List of rating data: "+ratingsDataOfUser);
		List<Rating> ratings = Arrays.stream(ratingsDataOfUser).toList();
		List<Rating> ratingList = ratings.stream().map(rating->{
			ResponseEntity<Hotel> ratingsWithHotelDetails = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			Hotel hotel = ratingsWithHotelDetails.getBody();
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		user.setRating(ratingList);
		return user;
		*/
		
		//********fetch rating from Rating Service using FeignClient(USING FEIGN CLIENT)*******************
		
		Rating[] ratingsDataOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getId(), Rating[].class);
		System.out.println("List of rating data: "+ratingsDataOfUser);
		List<Rating> ratings = Arrays.stream(ratingsDataOfUser).toList();
		List<Rating> ratingList = ratings.stream().map(rating->{
			//ResponseEntity<Hotel> ratingsWithHotelDetails = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelService.getHotel(rating.getHotelId()); //Feign Client Call
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		user.setRating(ratingList);
		return user;
		
	}

}
