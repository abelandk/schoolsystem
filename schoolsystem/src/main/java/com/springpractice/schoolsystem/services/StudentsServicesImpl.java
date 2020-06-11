package com.springpractice.schoolsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springpractice.schoolsystem.dao.StudentsDAO;
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

}
