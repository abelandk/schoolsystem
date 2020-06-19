package com.springpractice.schoolsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springpractice.schoolsystem.entities.Courses;
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
		Students student = session.get(Students.class, id);
		
		return student;
	}

	@Override
	@Transactional
	public int addStudent(Students student) {
		
		Session session = entityManager.unwrap(Session.class);
		session.save(student);
		return student.getId();
	}

	@Override
	@Transactional
	public List<Courses> getCourses(int student_id) {
		
		Session session = entityManager.unwrap(Session.class);
		Students student = session.get(Students.class, student_id);

		return student.getCourses();
	}
	
	@Override
	@Transactional
	public void setCourse(int student_id, Courses course) {
		
		Session session = entityManager.unwrap(Session.class);
		Students student = session.get(Students.class, student_id);

		student.setCourses(course);
	}

}
