package com.example.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.beans.User;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String goHome() {
		System.out.println("in home controller");
		return "index";
	}
	
	@GetMapping("/goToSearch")
	public String goToSearch() {
		System.out.println("Goto Search page");
		return "search";
	}
	
	@GetMapping("/goToRegistration")
	public String goToRegistration() {
		System.out.println("Goto Register page");
		return "register";
	}
	
	@GetMapping("/goToLogin")
	public String goToLogin() {
		System.out.println("Goto Login page");
		return "login";
	}
	
	@ModelAttribute("newuser")
	public User getDefaultUser() {
		return new User();
	}
	@ModelAttribute("genderItems")
	public List<String> getGenderItems() {
		return Arrays.asList(new String[] {"Male","Female","Other"});
	}
	
}
