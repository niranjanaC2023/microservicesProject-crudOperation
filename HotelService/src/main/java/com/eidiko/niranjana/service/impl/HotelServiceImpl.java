package com.eidiko.niranjana.service.impl;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eidiko.niranjana.entity.Hotel;
import com.eidiko.niranjana.exception.ResourceNotFoundException;
import com.eidiko.niranjana.repo.IHotelRepository;
import com.eidiko.niranjana.service.IHotelService;

@Service
public class HotelServiceImpl implements IHotelService 
{
	@Autowired
	IHotelRepository hotelRepo;
	
	@Override
	public Hotel saveHotelData(Hotel hotel) 
	{		
		//Generate Random ID in DB
		String randomIdGenerate = UUID.randomUUID().toString();
		hotel.setId(randomIdGenerate);		
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotelData() 
	{
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getSingleHHotelData(String hotelId)
	{
		return hotelRepo.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel with Given ID not Found"+hotelId));
	}

}
