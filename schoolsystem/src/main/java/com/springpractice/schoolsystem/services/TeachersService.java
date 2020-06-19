package com.springpractice.schoolsystem.services;

import java.util.List;

import com.springpractice.schoolsystem.entities.Teachers;

public interface TeachersService {

	public List<Teachers> getAllTeachers();
	public Teachers getTeacher(int id);
	public void setTeacher(Teachers teacher);
}
