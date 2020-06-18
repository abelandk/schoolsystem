package com.springpractice.schoolsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springpractice.schoolsystem.dao.StudentsDAO;
import com.springpractice.schoolsystem.entities.Courses;
import com.springpractice.schoolsystem.entities.Students;

@Service
public class StudentsServicesImpl implements StudentsServices {

	@Autowired
	public StudentsDAO dao;
	
	@Override
	@Transactional
	public List<Students> getStudents() {
		
		return dao.getStudents();
	}

	@Override
	@Transactional
	public Students getStudent(int id) {
		
		return dao.getStudents(id);
	}

	@Override
	@Transactional
	public int addStudent(Students student) {
		return dao.addStudent(student);
	}

	@Override
	@Transactional
	public List<Courses> getCourses(int student_id) {
		return dao.getCourses(student_id);
	}

	@Override
	@Transactional
	public void setCourse(int student_id, Courses course) {
		dao.setCourse(student_id, course);
		
	}

}
