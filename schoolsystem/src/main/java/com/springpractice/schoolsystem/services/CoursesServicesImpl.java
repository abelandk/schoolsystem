package com.springpractice.schoolsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springpractice.schoolsystem.dao.CoursesDAO;
import com.springpractice.schoolsystem.entities.Courses;
import com.springpractice.schoolsystem.entities.Students;

@Service
public class CoursesServicesImpl implements CoursesServices {

	@Autowired
	private CoursesDAO dao;
	
	@Override
	@Transactional
	public List<Courses> getCourses() {
		
		return dao.getCourses();
	}

	@Override
	@Transactional
	public Courses getCourse(int id) {

		return dao.getCourse(id);
	}

	@Override
	@Transactional
	public void setCourse(String code, String name) {

		dao.setCourse(code, name);
	}

	@Override
	public List<Students> getStudents(int course_id) {

		return dao.getStudents(course_id);
	}

	@Override
	public void setStudent(int course_id, Students student) {

		dao.setStudent(course_id, student);
	}

}
