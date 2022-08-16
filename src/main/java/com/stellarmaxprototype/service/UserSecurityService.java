package com.stellarmaxprototype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.stellarmaxprototype.entity.UserSecurity;
import com.stellarmaxprototype.entity.User;
import com.stellarmaxprototype.repository.UserRepository;

public class UserSecurityService implements UserDetailsService{
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		User user = repo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new UserSecurity(user);
	}

}
