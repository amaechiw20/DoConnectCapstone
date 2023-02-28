package com.doconnect.configuration;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.doconnect.service.JwtService;
import com.doconnect.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private JwtService jwtService;	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		

		final String header = request.getHeader("Authorization"); 
		String jwtToken = null;
		String userName = null;
		if(header != null && header.startsWith("Bearer")) {
			jwtToken = header.substring(7);
			
			try {
				userName = jwtUtil.getUsernameFromToken(jwtToken);
				
			}catch (IllegalArgumentException e) {
				System.out.println("Unable to get Jwt Token!");
			} catch(ExpiredJwtException e) {
				System.out.println("Jwt Token Expired!");
			}
		}else {
			System.out.println("Jwt Token doesn't start with Bearer!");
		}
		
		if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = jwtService.loadUserByUsername(userName);
			
			if(jwtUtil.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken userNamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
				userNamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);	
	}
}
