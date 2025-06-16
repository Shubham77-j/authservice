package com.authservice_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authservice_1.Service.AuthService;
import com.authservice_1.dto.ApiResponse;
import com.authservice_1.dto.LoginDto;
import com.authservice_1.dto.UserDto;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private AuthService authservice;
	
@PostMapping("/register")
public ResponseEntity<ApiResponse<String>>register(@RequestBody UserDto dto){
	ApiResponse<String>response=authservice.register(dto);
	return new ResponseEntity<>(response , HttpStatusCode.valueOf(response.getStatus()));
	
}
@PostMapping("/login")
public ResponseEntity<ApiResponse<String>>login(@RequestBody LoginDto dto){
	
	UsernamePasswordAuthenticationToken token = 
			new UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword());
	
	        authenticationManager.authenticate(token);
	return null;
	
}

}
