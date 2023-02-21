/**
 * 
 */
package com.doConnect.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.doConnect.entity.User;

/**
 * @author : Edward Lam
 * @date   : 2023-02-20
 */
public class UserController {
	@GetMapping("/")
	public void Home(){
		
	}
	
	@GetMapping("/adduser")
	public void addUser() {
		
	}
	
	@GetMapping("/addnewuser")
	public void addNewUser(){
		
	}
	
	@GetMapping("/getLogin")
	public void getLogin(){
		
	}
	
	@GetMapping("/getallusers")
	public List<User> getAllUser(){
		return new ArrayList<User>();
	}
	
	@GetMapping("/getuserbyId")
	public User getUserbyId(int uid) {
		return new User();
	}
	
	@GetMapping("/updateuser")
	public void updateUser() {
		
	}
	
	@GetMapping("/getbyname")
	public void getbyName() {
		
	}
	
	@GetMapping("/getbyalluserType")
	public List<User> getbyAllUserType(){
		return new ArrayList<User>();
	}
	
	@GetMapping("/loginVerify")
	public void userLoginVerify() {
		
	}
}
