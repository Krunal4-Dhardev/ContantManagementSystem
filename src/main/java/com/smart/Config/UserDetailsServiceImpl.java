package com.smart.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.dao.UserRepository;
import com.smart.entities.User;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		//Fatching User from Database
		User user =userRepo.getUserByEmail(email);
		
		if(user == null)
		{
			throw new UsernameNotFoundException("Could Not Found User !!");
		}
		CustomUserDetails detail =new CustomUserDetails(user);
		return detail;
	}
}
