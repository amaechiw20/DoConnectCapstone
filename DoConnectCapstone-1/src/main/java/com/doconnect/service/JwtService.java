package com.doconnect.service;

import java.util.HashSet;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.doconnect.entity.JwtRequest;
import com.doconnect.entity.JwtResponse;
import com.doconnect.entity.User;
import com.doconnect.repo.UserRepository;
import com.doconnect.util.JwtUtil;

@Service
public class JwtService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authManager;
	
	public JwtResponse createJwtToken(JwtRequest jwtRequest)throws Exception {
		String username = jwtRequest.getUsername();
		String password = jwtRequest.getPassword();
		authenticate(username, password);
		
		final UserDetails userDetails = loadUserByUsername(username);
		String newGeneratedToken = jwtUtil.generateToken(userDetails);
		User user = userRepo.findByUsername(username);
		return new JwtResponse(user, newGeneratedToken);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if(user != null) {
			return new org.springframework.security.core.userdetails.User(
					user.getUsername(),  user.getPassword(), getAuthorities(user));
		} else {
			throw new UsernameNotFoundException("Username is not valid!");
		}
	}
	
	private Set getAuthorities(User user) {
		Set authorities = new HashSet<>();
		user.getType().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getUsertype()));
		});
		return authorities;
	}
	
	public void authenticate(String username, String password) throws Exception {
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch (DisabledException e) {
			System.out.println("User is disabled!");
		}catch (BadCredentialsException e) {
			System.out.println("Bad Credentials!");
		}
	}
}
