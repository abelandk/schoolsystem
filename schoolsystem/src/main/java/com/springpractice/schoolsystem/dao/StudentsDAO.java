package com.springpractice.schoolsystem.dao;

import java.util.List;

import com.springpractice.schoolsystem.entities.Courses;
import com.springpractice.schoolsystem.entities.Students;

public interface StudentsDAO {
	
	public List<Students> getStudents();

	public Students getStudents(int id);
	
	public Students getStudentByUser(int userId);

	public int addStudent(Students student);
	
	public List<Courses> getCourses(int studentId);

	public void setCourse(int studentId, Courses course);

}
