package com.springpractice.schoolsystem.services;

import java.util.List;

import com.springpractice.schoolsystem.entities.Students;

public interface StudentsServices {
	
	public List<Students> getStudents();

	public Students getStudent(int id);

	public int addStudent(Students student);

}
