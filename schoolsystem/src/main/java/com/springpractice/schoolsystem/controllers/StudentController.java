package com.springpractice.schoolsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
	
	@GetMapping("/students")
	public String students() {
		
		return "students";
	}

}
