package com.springpractice.schoolsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springpractice.schoolsystem.entities.Courses;
import com.springpractice.schoolsystem.entities.Students;
import com.springpractice.schoolsystem.services.CoursesServices;
import com.springpractice.schoolsystem.services.StudentsServices;

@Controller
public class StudentController {
	
	@Autowired
	public StudentsServices studentService;
	
	@Autowired
	public CoursesServices courseService;
	
	@GetMapping("/students")
	public String students(Model model) {
		
		model.addAttribute("students", studentService.getStudents());
		return "students";
	}
	
	@PostMapping("/studentapi")
	public String studentFromAPI(@ModelAttribute(value="id") int id, Model model) {
		
		model.addAttribute("students", studentService.getStudent(id));
		return "students";
	}
	
	@GetMapping("/studentRegistrationForm")
	public String student(Model model) {
		
		model.addAttribute("student", new Students());
		return "student-registration-form";
	}
	
	@PostMapping("/studentRegistration")
	public String student(Students student, Model model) {
		
		int studentId = studentService.addStudent(student);
		model.addAttribute("students", studentService.getStudent(studentId));
		return "students";
	}
	
	@PostMapping("/student")
	public String student(int id, Model model) {
		
		model.addAttribute("student", studentService.getStudent(id));
		model.addAttribute("courses", courseService.getCourses());
		return "student";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	

}
