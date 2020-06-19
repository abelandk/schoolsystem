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
public class CoursesDAOImpl implements CoursesDAO {

	@Autowired
	private EntityManager em;
	
	Session session;
	
	@Override
	@Transactional
	public List<Courses> getCourses() {
		session = em.unwrap(Session.class);
		Query<Courses> courses = session.createQuery("from Courses", Courses.class);
		return courses.getResultList();
	}

	@Override
	@Transactional
	public Courses getCourse(int id) {
		session = em.unwrap(Session.class);
		Courses course = session.get(Courses.class, id);
		return course;
	}

	@Override
	@Transactional
	public void setCourse(String code, String name) {
		session = em.unwrap(Session.class);
		session.save(new Courses(code, name));
	}

	@Override
	@Transactional
	public List<Students> getStudents(int course_id) {
		
		session = em.unwrap(Session.class);
		Courses course = session.get(Courses.class, course_id);
		
		return course.getStudents();
	}

	@Override
	@Transactional
	public void setStudent(int course_id, Students student) {
		
		session = em.unwrap(Session.class);
		Courses course = session.get(Courses.class, course_id);
		course.setStudent(student);
	}

}
