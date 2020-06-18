package com.springpractice.schoolsystem.services;

import java.util.List;

import com.springpractice.schoolsystem.entities.Courses;
import com.springpractice.schoolsystem.entities.Students;

public interface CoursesServices {

	public List<Courses> getCourses();
	public Courses getCourse(int id);
	default void setCourse(Courses course) {
		setCourse(course.getCode(), course.getName());
	}
	public void setCourse(String code, String name);
	
	public List<Students> getStudents(int course_id);
	
	public void setStudent(int course_id, Students student);
}
