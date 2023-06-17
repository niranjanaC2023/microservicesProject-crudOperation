package com.eidiko.niranjana.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eidiko.niranjana.entity.Rating;

/*public interface IRatingRepo extends JpaRepository<Rating, String> 
{
	//Custom finder method (get single rating by using ID)
	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);
}*/

public interface IRatingRepo extends MongoRepository<Rating, String> 
{
	//Custom finder method (get single rating by using ID)
	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);
}