//package com.authservice_1.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class AppSecurityConfig {
//	//configure how to keep
//	//1. Url open
//	//2. Url to authenticate
//	//3. Authorization
//	@Bean
//	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception{
//		
//		                                                                http.authorizeHttpRequests(
//				                                                                               req->{
//			                                                                                            req.requestMatchers("/api/v1/auth/hello").permitAll();
//		              }
//		
//		                    );
//                                                              		return http.build();
//		
//		
//	}
//	
//	
//
//}
