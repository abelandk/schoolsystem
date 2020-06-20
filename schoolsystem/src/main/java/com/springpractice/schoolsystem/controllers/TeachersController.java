package com.springpractice.schoolsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springpractice.schoolsystem.entities.Courses;
import com.springpractice.schoolsystem.entities.Teachers;
import com.springpractice.schoolsystem.services.CoursesServices;
import com.springpractice.schoolsystem.services.TeachersService;

@Controller
public class TeachersController {

	@Autowired
	TeachersService teachersServices;
	
	@Autowired
	CoursesServices coureseServices;
	
	@GetMapping("/teachers")
	public String getAllTeachers(Model model) {
		
		model.addAttribute("teachers", teachersServices.getAllTeachers());
		return "teachers";
	}
	
	@PostMapping("/teacher")
	public String getTeacher(@RequestParam("id") int id,
			@ModelAttribute("selectCourses") Courses course,
			Model model) {
		
		model.addAttribute("teacher", teachersServices.getTeacher(id));
		model.addAttribute("courses", coureseServices.getCourses());
		model.addAttribute("registeredCourses", teachersServices.getCourses(id));
		return "teacher";
	}
	
	@PostMapping("/registerCourse")
	public String registerCourse(@RequestParam("id") int cId,
			@RequestParam("teacher_id") int tId,
			@ModelAttribute("selectCourses") Courses course,
			Model model) {
		teachersServices.setCourses(coureseServices.getCourse(cId), tId);
		model.addAttribute("teacher", teachersServices.getTeacher(tId));
		model.addAttribute("courses", coureseServices.getCourses());
		model.addAttribute("registeredCourses", teachersServices.getCourses(tId));
		return "teacher";
	}
	
	@GetMapping("/registerTeachersForm")
	public String registerTeachersForm(Model model) {
		
		model.addAttribute("teachers", new Teachers());
		return "teachers-registration-form";
	}
	
	@PostMapping("/registerTeachersForm")
	public String registerTeachers(@ModelAttribute("teachers") Teachers teacher) {
		
		teachersServices.setTeacher(teacher);
		return "redirect:/teachers";
	}
}
