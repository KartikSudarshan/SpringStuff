package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.beans.User;
import com.example.demo.repository.UserRepository;

@Controller
public class RegistrationController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/registeruser")
	public String registerUser(@ModelAttribute("newuser") User user,Model model) {
		System.out.println("in registration");
		userRepository.save(user);
		model.addAttribute("DataSaved", "User got registered successfully");
		return "login";
	}
	
}
