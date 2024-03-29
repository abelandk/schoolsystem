package com.springpractice.schoolsystem.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Courses {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String code;
	private String name;
	
	@ManyToMany
	@JoinTable(
			 name = "student_course", //  name is the name of the join table in the database
			 joinColumns = @JoinColumn(name = "course_id"), // the name of the column in the database
			 inverseJoinColumns = @JoinColumn(name = "student_id") // the joined column name in the database
			)
	private List<Students> students;
	
	@ManyToMany
	@JoinTable(
			name = "teacher_course",
			joinColumns = @JoinColumn(name = "course_id"),
			inverseJoinColumns = @JoinColumn(name = "teacher_id"))
	private List<Teachers> teachers;
	
	public Courses() {

	}
	
	public Courses(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	public void setStudent(Students student) {

		if(this.students.isEmpty()) {
			this.students = new ArrayList<>();
		}
		
		this.students.add(student);
	}

	public List<Teachers> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teachers> teachers) {
		this.teachers = teachers;
	}
	
	public void setTeacher(Teachers teachers) {
		
		if(this.teachers.isEmpty()) {
			this.teachers = new ArrayList<>();
		}
		
		this.teachers.add(teachers);
	}

}
