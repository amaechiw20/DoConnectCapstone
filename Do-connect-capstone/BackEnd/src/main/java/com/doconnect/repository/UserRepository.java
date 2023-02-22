package com.doconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doconnect.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	public List<User> findByName(String name);
	public List<User> findByUserType(String userType);
}
