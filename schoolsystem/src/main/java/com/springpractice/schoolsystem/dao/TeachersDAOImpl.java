package com.springpractice.schoolsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springpractice.schoolsystem.entities.Courses;
import com.springpractice.schoolsystem.entities.Teachers;

@Repository
public class TeachersDAOImpl implements TeachersDAO {

	@Autowired
	private EntityManager em;
	
	private Session session;
	
	@Override
	@Transactional
	public List<Teachers> getAllTeachers() {
		session = em.unwrap(Session.class);
		Query<Teachers> teachers = session.createQuery("from Teachers", Teachers.class);
		return teachers.getResultList();
	}

	@Override
	@Transactional
	public Teachers getTeacher(int id) {

		session = em.unwrap(Session.class);
		Teachers teacher = session.get(Teachers.class, id);
		return teacher;
	}

	@Override
	@Transactional
	public void setTeacher(Teachers teacher) {
		
		session= em.unwrap(Session.class);
		session.save(teacher);
	}

	@Override
	@Transactional
	public List<Courses> getCourses(int id) {
		
		session = em.unwrap(Session.class);
		Teachers teacher = session.get(Teachers.class, id);
		return teacher.getCourses();
	}

	@Override
	@Transactional
	public void setCourses(Courses course, int id) {
		
		session = em.unwrap(Session.class);
		Teachers teacher = session.get(Teachers.class, id);
		teacher.setCourses(course);
	}

}
