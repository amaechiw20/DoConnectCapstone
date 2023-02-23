/**
 * 
 */
package com.doConnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doConnect.entity.User;
import com.doConnect.exception.UserNotFoundException;
import com.doConnect.repository.UserRepository;
import com.doConnect.util.JwtUtil;

import com.doConnect.entity.AuthRequest;

/**
 * @author : Edward Lam
 * @date   : 2023-02-20
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
    private JwtUtil jwtUtil;
	
	@GetMapping("/")
	public void Home(){
		
	}
	
	@GetMapping("/adduser")
	public User addUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/addnewuser")
	public User addNewUser(@RequestBody User user){
		return userRepository.save(user);
	}
	
	@GetMapping("/getLogin")
	public void getLogin(){
		
	}
	
	@GetMapping("/getallusers")
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	@GetMapping("/getuserbyId")
	public ResponseEntity<User> getUserbyId(@PathVariable long uid) {
		User user = userRepository.findById( uid)
				.orElseThrow(() -> new UserNotFoundException("User not exist with id :" + uid));
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/updateuser")
	public ResponseEntity<User> updateUser(@PathVariable Long uid, @RequestBody User userDetails) {
		User user = userRepository.findById(uid)
				.orElseThrow(() -> new UserNotFoundException("User not exist with id :" + uid));
		
		user.setEmail(userDetails.getEmail());
		user.setName(userDetails.getName());
		user.setPassword(userDetails.getPassword());
		user.setUsername(userDetails.getUsername());
		user.setUserType(userDetails.getUserType());

		User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	@GetMapping("/getbyname")
	public List<User> getbyName(String name) {
		return userRepository.findByName(name);
	}
	
	@GetMapping("/getbyalluserType")
	public List<User> getbyAllUserType(String userType){
		return userRepository.findByUserType(userType);
	}
	
	@GetMapping("/loginVerify")
	public String userLoginVerify(@RequestBody AuthRequest authRequest) throws Exception {
		try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
	}
}
