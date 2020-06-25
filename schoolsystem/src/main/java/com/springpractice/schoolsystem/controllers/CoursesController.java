package com.springpractice.schoolsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springpractice.schoolsystem.entities.Courses;
import com.springpractice.schoolsystem.services.CoursesServices;

@Controller
@RequestMapping("/course")
public class CoursesController {

	@Autowired
	private CoursesServices services;
	
	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute("courses", services.getCourses());
		return "courses";
	}
	
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
	public String course(@ModelAttribute("course") Courses course, Model model) {
		services.setCourse(course);
		
		// redirect is done to avoid duplicate entry during reload
		return "redirect:/course/courses";
	}
	
}
