package com.springpractice.schoolsystem.services;

import java.util.List;

import com.springpractice.schoolsystem.entities.Courses;
import com.springpractice.schoolsystem.entities.Teachers;

public interface TeachersService {

	public List<Teachers> getAllTeachers();
	public Teachers getTeacher(int id);
	public Teachers getTeacherByUserId(int userId);
	public void setTeacher(Teachers teacher);
	public List<Courses> getCourses(int id);
	public void setCourses(Courses course, int id);
}
