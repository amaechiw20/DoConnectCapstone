package com.doconnect.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	private static final String SECRETE= "SECRETE_KEY"; 
	private static final int TOKEN_VALIDITY = 3600 * 5;
	
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	private <T> T getClaimFromToken(String token, Function<Claims, T> claimResolver) {
	
		final Claims claim = getAllClaimsFromToken(token);
		return claimResolver.apply(claim);
	}
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(SECRETE).parseClaimsJws(token).getBody();
	}
	
	public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = getUsernameFromToken(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
	
    private boolean isTokenExpired(String token) {
    	final Date expirationDate = getExpirationDateFromToken(token);
        return expirationDate.before(new Date());
    }
    
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
    

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
        		.setClaims(claims)
        		.setSubject(userDetails.getUsername())
        		.setIssuedAt(new Date(System.currentTimeMillis()))
        		.setExpiration(new Date(System.currentTimeMillis()+TOKEN_VALIDITY*1000))
        		.signWith(SignatureAlgorithm.HS512, SECRETE)
        		.compact();
    }
}
