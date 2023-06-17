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

import com.eidiko.niranjana.entity.Hotel;
import com.eidiko.niranjana.service.IHotelService;

@RestController
@RequestMapping(value="/hotels")
public class HotelController {

	@Autowired
	IHotelService hotelService;
	
	@PostMapping("/dataSave")
	public ResponseEntity<Hotel> saveHotelDataIntoDB(@RequestBody Hotel hotelData)
	{
		Hotel data = hotelService.saveHotelData(hotelData);
		return ResponseEntity.status(HttpStatus.CREATED).body(data);
	}
	
	
	@GetMapping("/fetchData")
	public ResponseEntity<List<Hotel>> fetchAlleHotelDataFromDB()
	{
		List<Hotel> data = hotelService.getAllHotelData();
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> fetchSingleeHotelDataFromDB(@PathVariable String hotelId)
	{
		Hotel data = hotelService.getSingleHHotelData(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
	
}
