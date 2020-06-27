package com.springpractice.schoolsystem.services;

import java.util.List;

import com.springpractice.schoolsystem.entities.Courses;
import com.springpractice.schoolsystem.entities.Students;

public interface StudentsServices {
	
	public List<Students> getStudents();

	public Students getStudent(int id);
	
	public Students getStudentByUser(int userId);

	public int addStudent(Students student);
	
	public List<Courses> getCourses(int student_id);

	public void setCourse(int student_id, Courses course);

}
