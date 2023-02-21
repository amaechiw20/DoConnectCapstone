package com.doconnect.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doconnect.entity.User;
import com.doconnect.exception.ResourceNotFoundException;
import com.doconnect.repository.UserRepository;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	//add user
	@PostMapping("/adduser")
	public User AddUser(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	// Login User to be done
	@GetMapping("/getLogin")
	public void GetLogin() {
		
	}
	
	// get all users
	@GetMapping("/getallusers")
	public List<User> GetAllUsers(){
		return userRepo.findAll();
	}
	
	
	//get a specific user by id
	@GetMapping("/getuserbyId/{id}")
	public ResponseEntity<User> GetUserbyId(@PathVariable Integer id){
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id :" + id+" doesn't exist!!!"));
		
		return ResponseEntity.ok(user);
	}
	
	// update user details
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<User> UpdateUser(@PathVariable Integer id, @RequestBody User userDetails){
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id :" + id+" doesn't exist!!!"));
		
		user.setName(userDetails.getName());
		user.setUsername(userDetails.getUsername());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());

		User updatedUser = userRepo.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	//get user by name
	@GetMapping("/getbyname/{name}")
	public List<User> GetbyName(@PathVariable String name){
		
		return userRepo.findByName(name);
	}
	
	//get all user type
	@GetMapping("/getallbyusertype")
	public List<User> GetAllUserType(@PathVariable String userType){
		return userRepo.findByUserType(userType);
	}
	
	
}
