package com.springpractice.schoolsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.schoolsystem.dao.UserDAO;
import com.springpractice.schoolsystem.entities.User;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserDAO dao;
	
	@Override
	public User getUser(String username) {

		return dao.getUser(username);
	}

}
