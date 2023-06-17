package com.eidiko.niranjana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eidiko.niranjana.entity.Hotel;

public interface IHotelRepository extends JpaRepository<Hotel, String> {

}
