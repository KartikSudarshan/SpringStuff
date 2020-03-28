package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

	@GetMapping("/search")
	public String search() {
		System.out.println("in Search Controller");
		return "search";
	}
	
	
	
}
