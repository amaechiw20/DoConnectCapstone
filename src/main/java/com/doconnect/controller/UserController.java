package com.doconnect.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.doconnect.entity.JwtRequest;
import com.doconnect.entity.JwtResponse;
import com.doconnect.entity.User;
import com.doconnect.service.JwtService;
import com.doconnect.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void initAdminandUserType(){
		userService.initAdminandUserType();
	}
	
	@Autowired
	private JwtService jwtService;
	
	//add user
	@PostMapping("/adduser")
	public User AddUser(@RequestBody User user) {
		return userService.AddUser(user);
	}
	
	@PostMapping("/addadmin")
	public User AddAdmin(@RequestBody User user) {
		return userService.AddAdmin(user);
	}

	// Login Admin
	@PostMapping("/getLogin")
	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		return jwtService.createJwtToken(jwtRequest);
	}
	
	// get all users
	@GetMapping("/getallusers")
	public List<User> GetAllUsers(){
		return userService.GetAllUsers();
	}
	
	
	//get a specific user by id
	@GetMapping("/getuserbyId/{id}")
	public ResponseEntity<User> GetUserbyId(@PathVariable Integer id){
		return userService.GetUserbyId(id);
	}
	
	// update user details
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<User> UpdateUser(@PathVariable Integer id, @RequestBody User userDetails){
		return userService.UpdateUser(id, userDetails);
	}
	
	//get user by name
	@GetMapping("/getbyname/{name}")
	public List<User> GetbyName(@PathVariable String name){
		
		return userService.GetbyName(name);
	}
	
	//get all user type
	@GetMapping("/getallbyusertype")
	public List<User> GetAllUserType(@PathVariable String userType){
		return userService.GetAllUserType(userType);
	}	
}