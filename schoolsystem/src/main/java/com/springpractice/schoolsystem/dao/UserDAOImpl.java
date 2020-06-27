package com.springpractice.schoolsystem.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springpractice.schoolsystem.entities.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private EntityManager em;
	
	private Session session;
	
	@Override
	@Transactional
	public User getUser(int id) {
		
		session = em.unwrap(Session.class);
		User user = session.get(User.class, id);
		return user;
	}

	@Override
	@Transactional
	public User getUser(String username) {
		
		session = em.unwrap(Session.class);
		Query<User> user = session.createQuery("FROM User U WHERE U.username = '" + username + "'", User.class);
		
		if(user.getResultList().size() < 1) {
			return null;
		}
		return user.getSingleResult();
	}

}
