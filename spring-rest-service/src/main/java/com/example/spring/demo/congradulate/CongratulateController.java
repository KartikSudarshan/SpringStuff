package com.example.spring.demo.congradulate;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CongratulateController {
	private static final String template = "Congratulations, %s!";
	private final AtomicLong counter = new AtomicLong();
	@GetMapping("/congrats")
	public Congratulate getCongratulations(@RequestParam(value="name", defaultValue="who ever you are") String name) {
		
		return new Congratulate(counter.incrementAndGet(), String.format(template, name));
		
	}
	
}
