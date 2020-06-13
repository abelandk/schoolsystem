package com.springpractice.schoolsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springpractice.schoolsystem.entities.Courses;
import com.springpractice.schoolsystem.services.CoursesServices;

@Controller
public class CoursesController {

	@Autowired
	private CoursesServices services;
	
	@GetMapping("/courseRegistrationForm")
	public String courseRegistration(Model model) {
		
		model.addAttribute("course", new Courses());
		return "course-registration-form";
	}
	
	@GetMapping("/courses")
	public String courses(Model model) {
		
		model.addAttribute("courses", services.getCourses());
		return "courses";
	}
	
	@PostMapping("/courseRegistration")
	public String course(Courses course, Model model) {
		services.setCourse(course);
		model.addAttribute("courses", services.getCourses());
		return "courses";
	}
	
}
