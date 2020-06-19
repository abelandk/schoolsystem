package com.springpractice.schoolsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springpractice.schoolsystem.entities.Teachers;
import com.springpractice.schoolsystem.services.TeachersService;

@Controller
public class TeachersController {

	@Autowired
	TeachersService services;
	
	@GetMapping("/teachers")
	public String getAllTeachers(Model model) {
		
		model.addAttribute("teachers", services.getAllTeachers());
		return "teachers";
	}
	
	@GetMapping("/registerTeachersForm")
	public String registerTeachersForm(Model model) {
		
		model.addAttribute("teachers", new Teachers());
		return "teachers-registration-form";
	}
	
	@PostMapping("/registerTeachersForm")
	public String registerTeachers(@ModelAttribute("teachers") Teachers teacher) {
		
		services.setTeacher(teacher);
		return "redirect:/teachers";
	}
}
