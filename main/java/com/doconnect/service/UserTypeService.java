package com.doconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doconnect.entity.UserType;
import com.doconnect.repo.UserTypeRepository;

@Service
public class UserTypeService {
	
	@Autowired
	private UserTypeRepository userTypeRepo;
	
	public UserType createNewUserType(UserType userType) {
		return userTypeRepo.save(userType);
	}
}
