package com.authservice_1.Service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authservice_1.entity.User;
import com.authservice_1.reposiotory.UserRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user= userRepository.findByUsername(username);
	
	return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),Collections.emptyList());

	}

}
