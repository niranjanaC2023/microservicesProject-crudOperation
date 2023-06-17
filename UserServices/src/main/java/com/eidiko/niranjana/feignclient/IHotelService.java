package com.eidiko.niranjana.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.eidiko.niranjana.entity.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface IHotelService 
{
	@GetMapping("/hotels/{hotelId}")
	public Hotel getHotel(@PathVariable String hotelId);
}
