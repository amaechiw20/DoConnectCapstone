package com.doconnect.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.doconnect.entity.User;
import com.doconnect.entity.UserType;
import com.doconnect.exception.ResourceNotFoundException;
import com.doconnect.repo.UserRepository;
import com.doconnect.repo.UserTypeRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserTypeRepository userTypeRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void initAdminandUserType() {

		UserType adminType = new UserType();
		adminType.setUsertype("Admin");
		adminType.setUsertypedescription("Administrator Role");

		UserType userType = new UserType();
		userType.setUsertype("User");
		userType.setUsertypedescription("A System User Role");
		
		User admin = new User();
		admin.setName("Natanim Issa");
		admin.setEmail("natanim@gmail.com");
		admin.setUsername("natanim");
		admin.setPassword(getEncoddedPassword("123456789"));
		Set<UserType> usertypeA = new HashSet<>();
		usertypeA.add(adminType);
		admin.setType(usertypeA);
		userRepo.save(admin);
		
		User user = new User();
		user.setName("Natanim Issa Eibrahim");
		user.setEmail("natanim@gmail.com");
		user.setUsername("natanimissa");
		user.setPassword(getEncoddedPassword("123456789"));
		Set<UserType> usertypeU = new HashSet<>();
		usertypeU.add(userType);
		user.setType(usertypeU);
		userRepo.save(user);	
	}
	
	//add user
	public User AddUser(User user) {
		UserType role = userTypeRepo.findById("User").get();
		Set<UserType> roles = new HashSet<>();
		roles.add(role);
		user.setType(roles);
		user.setPassword(getEncoddedPassword(user.getPassword()));
		return userRepo.save(user);
	}
	public User AddAdmin(User user) {
		UserType role = userTypeRepo.findById("Admin").get();
		Set<UserType> roles = new HashSet<>();
		roles.add(role);
		user.setType(roles);
		user.setPassword(getEncoddedPassword(user.getPassword()));
		return userRepo.save(user);
	}

	// get all users
	public List<User> GetAllUsers(){
		return (List<User>) userRepo.findAll();
	}
	
	
	//get a specific user by id
	public ResponseEntity<User> GetUserbyId(String id){
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id :" + id+" doesn't exist!!!"));
		
		return ResponseEntity.ok(user);
	}
	
	// update user details
	public ResponseEntity<User> UpdateUser(String id, User userDetails){
		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id :" + id+" doesn't exist!!!"));
		
		user.setName(userDetails.getName());
		user.setUsername(userDetails.getUsername());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());

		User updatedUser = userRepo.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	//get user by name
	public List<User> GetbyName(String name){
		
		return userRepo.findByName(name);
	}
	
	//get all user type
	@GetMapping("/getallbyusertype")
	public List<User> GetAllUserType(String userType){
		return userRepo.findByUsertype(userType);
	}
	
	public String getEncoddedPassword(String password) {
		return passwordEncoder.encode(password);
	}
}