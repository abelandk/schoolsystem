package com.springpractice.schoolsystem.dao;

import java.util.List;

import com.springpractice.schoolsystem.entities.Courses;
import com.springpractice.schoolsystem.entities.Students;

public interface StudentsDAO {
	
	public List<Students> getStudents();

	public Students getStudents(int id);

	public int addStudent(Students student);
	
	public List<Courses> getCourses(int student_id);

	public void setCourse(int student_id, Courses course);

}
