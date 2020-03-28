package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
