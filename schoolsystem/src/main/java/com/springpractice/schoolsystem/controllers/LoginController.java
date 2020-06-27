package com.springpractice.schoolsystem.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@GetMapping("/")
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
	
	/*
	 * @PostMapping("/authenticateTheUser") public String
	 * authenticateTheUser(@RequestParam("username") String username) {
	 * 
	 * System.out.println(username); return "access-denied";
	 * 
	 * }
	 */
	
	  @GetMapping("/username")
	  @ResponseBody
	  public String currentUserName(Authentication authentication) {
		 
	     return  authentication.getName();
	  }

}
