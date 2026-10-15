package com.parameter.practice.controller;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parameter.practice.dto.LoginRequest;
import com.parameter.practice.dto.LoginResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private final AuthenticationManager authenticationManager;
	private final JwtEncoder jwtEncoder;
	
	public AuthController(AuthenticationManager authenticationManager, JwtEncoder jwtEncoder) {
		this.authenticationManager = authenticationManager;
		this.jwtEncoder = jwtEncoder;
	}
	
	@PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request)  {
      
		Authentication authentication = authenticationManager.authenticate(
			    new UsernamePasswordAuthenticationToken(
			        request.getUsername(),
			        request.getPassword()
			    )
			);
		
		Instant now = Instant.now();
		
	     JwtClaimsSet claims = JwtClaimsSet.builder()
	                .issuer("spring-security-demo")
	                .issuedAt(now)
	                .expiresAt(now.plus(15, ChronoUnit.MINUTES))
	                .subject(authentication.getName())
	                .claim(
	                    "scope",
	                    authentication.getAuthorities().stream()
	                        .map(authority -> authority.getAuthority())
	                        .toList()
	                )
	                .build();
		
	     String token = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	     
	     return new LoginResponse(token,"Bearer");
	}	
}
