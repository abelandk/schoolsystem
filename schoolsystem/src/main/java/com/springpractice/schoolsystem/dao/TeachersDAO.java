package com.springpractice.schoolsystem.dao;

import java.util.List;

import com.springpractice.schoolsystem.entities.Teachers;

public interface TeachersDAO {

	public List<Teachers> getAllTeachers();
	public Teachers getTeacher(int id);
	public void setTeacher(Teachers teacher);
}
