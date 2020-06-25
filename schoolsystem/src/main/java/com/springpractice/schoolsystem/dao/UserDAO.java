package com.springpractice.schoolsystem.dao;

import com.springpractice.schoolsystem.entities.User;

public interface UserDAO {

	public User getUser(int id);

	public User getUser(String username);
}
