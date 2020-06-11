package com.springpractice.schoolsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springpractice.schoolsystem.entities.Students;

@Repository
public class StudentsDAOImpl implements StudentsDAO {
	
	public EntityManager entityManager;

	@Autowired
	public StudentsDAOImpl(EntityManager em) {
		entityManager = em;
	}

	@Override
	@Transactional
	public List<Students> getStudents() {
		
		Session session = entityManager.unwrap(Session.class);
		Query<Students> students = session.createQuery("from Students", Students.class);
		
		return students.getResultList();
	}

	@Override
	@Transactional
	public Students getStudents(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		Query<Students> student = session.createQuery("from Students where id=" + id, Students.class);
		
		return student.getSingleResult();
	}

}
