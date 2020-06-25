package com.springpractice.schoolsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springpractice.schoolsystem.dao.UserDAO;
import com.springpractice.schoolsystem.entities.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDAO dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = dao.getUser(username);
		
		UserDetailsImpl userDetails = new UserDetailsImpl(user);
		
		return userDetails;
	}

}
