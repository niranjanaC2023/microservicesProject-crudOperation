package com.eidiko.niranjana.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eidiko.niranjana.entity.User;
import com.eidiko.niranjana.service.IUserService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping(value="/users")
public class UserController 
{

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	IUserService userService;
	
	@PostMapping("/dataSave")
	public ResponseEntity<User> saveHotelDataIntoDB(@RequestBody User userData)
	{
		User data = userService.saveIntoDB(userData);
		return ResponseEntity.status(HttpStatus.CREATED).body(data);
	}
	
	
	//@GetMapping("/fetchData")
	@GetMapping
	public ResponseEntity<List<User>> fetchAllUserDataFromDB()
	{
		List<User> data = userService.getAllUserData();
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
	
	/*
	//@CircuitBreaker Apply
	@GetMapping("/{userId}")
	@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallbackMethod")
	public ResponseEntity<User> fetchSingleUserDataFromDB(@PathVariable String userId)
	{
		User data = userService.getSingleUser(userId);
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
	//Creating fall back method for CircuitBreaker(CREATING FALL BACK METHOD FOR CIRCUITBREAKER)
	public ResponseEntity<User> ratingHotelFallbackMethod(String userId,Exception ex)
	{
		logger.info("Fallback is excuted because service is down: "+ex.getMessage());
		User user = User.builder()
				.email("dummy@gmail.com")
		        .name("Dummy")
		        .about("This user is created dummy because some service is down")
		        .id("127127")
		        .build();
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	*/
	/*
	//@Retry Apply
	int retryCount = 1;
	@GetMapping("/{userId}")
	@Retry(name="ratingHotelRetry",fallbackMethod = "ratingHotelFallbackMethodForRetry")
	public ResponseEntity<User> fetchSingleUserDataFromDB(@PathVariable String userId)
	{
		logger.info("Retry Count is: "+retryCount);
		retryCount++;
		User data = userService.getSingleUser(userId);
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
	//Creating fall back method for Retry(CREATING FALL BACK METHOD FOR "RETRY")
	public ResponseEntity<User> ratingHotelFallbackMethodForRetry(String userId,Exception ex)
	{
			
			User user = User.builder()
					.email("dummy@gmail.com")
			        .name("Dummy")
			        .about("This user is created dummy because some service is down")
			        .id("127127")
			        .build();
			return new ResponseEntity<>(user,HttpStatus.OK);
	}
	*/
	
	
	//@RateLimiter Apply
	@GetMapping("/{userId}")
	@RateLimiter(name="ratingHotelUserRateLimiter",fallbackMethod = "ratingHotelFallbackMethod")
	public ResponseEntity<User> fetchSingleUserDataFromDB(@PathVariable String userId)
	{
		User data = userService.getSingleUser(userId);
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
	//Creating fall back method for RateLimiter(CREATING FALL BACK METHOD FOR RATELIMITER)
	public ResponseEntity<User> ratingHotelFallbackMethod(String userId,Exception ex)
	{
		logger.info("Fallback is excuted because service is down: "+ex.getMessage());
		User user = User.builder()
				.email("dummy@gmail.com")
		        .name("Dummy")
		        .about("This user is created dummy because some service is down")
		        .id("127127")
		        .build();
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
}
