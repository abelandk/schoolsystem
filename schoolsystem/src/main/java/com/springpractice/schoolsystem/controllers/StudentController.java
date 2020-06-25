package com.springpractice.schoolsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springpractice.schoolsystem.entities.Courses;
import com.springpractice.schoolsystem.entities.Students;
import com.springpractice.schoolsystem.services.CoursesServices;
import com.springpractice.schoolsystem.services.StudentsServices;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	public StudentsServices studentService;
	
	@Autowired
	public CoursesServices courseService;
	
	@GetMapping("/")
	public String welcome() {
		
		return "redirect:/student/students";
	}
	
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
	public String student(@RequestParam("id") int id, Model model, 
			@ModelAttribute("selectedCourses") Courses courses) {
		
		model.addAttribute("student", studentService.getStudent(id));
		model.addAttribute("courses", courseService.getCourses());
		model.addAttribute("registeredCourses", studentService.getCourses(id));
		return "student";
	}
	
	@PostMapping("/studentCourseRegistration")
	public String studentx(@RequestParam("id") int cId,
			@RequestParam("student_id") int sId,
			Model model,
			@ModelAttribute("selectedCourses") Courses courses) {

		studentService.setCourse(sId, courseService.getCourse(cId));

		model.addAttribute("student", studentService.getStudent(sId));
		model.addAttribute("courses", courseService.getCourses());
		model.addAttribute("registeredCourses", studentService.getCourses(sId));

		return "student";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	

}
