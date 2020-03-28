package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.beans.Product;
import com.example.demo.repository.ProductRepository;

@Controller
public class SearchController {

	@Autowired
	private ProductRepository ProductRepository;
	
	@GetMapping("/search")
	public String search(@RequestParam("search") String search,Model model) {
		System.out.println("in Search Controller");
		System.out.println("Search Criteria "+ search );
		
		List <Product> products=new ArrayList<>();
		products=ProductRepository.searchByName(search);
		model.addAttribute("products", products);
		return "search";
	}
	
	
	
}
