package com.springpractice.schoolsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springpractice.schoolsystem.dao.TeachersDAO;
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

}
