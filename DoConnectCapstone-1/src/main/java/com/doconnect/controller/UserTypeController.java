package com.doconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doconnect.entity.UserType;
import com.doconnect.service.UserTypeService;


@RestController
@RequestMapping("/")
public class UserTypeController {

	@Autowired
	private UserTypeService userTypeService;
	
	@PostMapping("/createnewusertype")
	public UserType createNewUserType(@RequestBody UserType userType) {
		return userTypeService.createNewUserType(userType);
	}
	
}
