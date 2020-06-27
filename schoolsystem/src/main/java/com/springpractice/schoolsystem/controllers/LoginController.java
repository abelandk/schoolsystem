package com.springpractice.schoolsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springpractice.schoolsystem.config.UserDetailsImpl;
import com.springpractice.schoolsystem.entities.Courses;
import com.springpractice.schoolsystem.entities.Students;
import com.springpractice.schoolsystem.services.CoursesServices;
import com.springpractice.schoolsystem.services.StudentsServices;

@Controller
public class LoginController {

	@Autowired
	private StudentsServices studentService;
	
	@Autowired
	private CoursesServices courseService;
	
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/index")
	public String index() {

		return "index";
	}

	@GetMapping("/login")
	public String login() {

		return "login";
	}

	/*
	 * @GetMapping("/logout") public String logout() {
	 * 
	 * return "login"; }
	 */

	@GetMapping("/access-denied")
	public String showAccessDenied() {

		return "access-denied";

	}

	
	  @GetMapping("/loginSucessful") 
	  public String loginSucessful(Model model, @ModelAttribute("selectedCourses") Courses courses) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  UserDetailsImpl loggedinUser = (UserDetailsImpl)auth.getPrincipal();
		  Students student = studentService.getStudentByUser(loggedinUser.getUser().getId());
		  
		  model.addAttribute("student", student);
		  model.addAttribute("courses", courseService.getCourses());
		  model.addAttribute("registeredCourses", studentService.getCourses(student.getId()));
		  return "student";
	  
	  }
	 

	@GetMapping("/username")
	@ResponseBody
	public String currentUserName(Authentication authentication) {

		return authentication.getName();
	}

}
