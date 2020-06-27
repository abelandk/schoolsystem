package com.springpractice.schoolsystem.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Students {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@ManyToMany
	@JoinTable(
			name = "student_course",  //  name is the name of the join table in the database
			joinColumns = @JoinColumn(name = "student_id"), // the name of the column in the database
			inverseJoinColumns = @JoinColumn(name = "course_id") // the joined column name in the database
			)
	private List<Courses> courses;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	public Students() {
		
	}

	public Students(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}
	
	public void setCourses(Courses course) {
		if(this.courses.isEmpty()) {
			this.courses = new ArrayList<>();
		}
		
		this.courses.add(course);		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + firstName + "]";
	}
	

}
