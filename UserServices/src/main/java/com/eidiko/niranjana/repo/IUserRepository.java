package com.eidiko.niranjana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eidiko.niranjana.entity.User;

public interface IUserRepository extends JpaRepository<User, String> {

}
