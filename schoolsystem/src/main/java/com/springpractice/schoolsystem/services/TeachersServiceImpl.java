package com.springpractice.schoolsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springpractice.schoolsystem.dao.TeachersDAO;
import com.springpractice.schoolsystem.entities.Courses;
import com.springpractice.schoolsystem.entities.Teachers;

@Service
public class TeachersServiceImpl implements TeachersService {

	@Autowired
	private TeachersDAO dao;
	
	@Override
	@Transactional
	public List<Teachers> getAllTeachers() {
		
		return dao.getAllTeachers();
	}

	@Override
	@Transactional
	public Teachers getTeacher(int id) {

		return dao.getTeacher(id);
	}

	@Override
	@Transactional
	public void setTeacher(Teachers teacher) {
		
		dao.setTeacher(teacher);
	}

	@Override
	@Transactional
	public List<Courses> getCourses(int id) {

		return dao.getCourses(id);
	}

	@Override
	@Transactional
	public void setCourses(Courses course, int id) {
		
		dao.setCourses(course, id);
		
	}

	@Override
	public Teachers getTeacherByUserId(int userId) {
		
		return dao.getTeacherByUser(userId);
	}

}
