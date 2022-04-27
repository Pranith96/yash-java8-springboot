package com.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello {
	
	@GetMapping("/data")
	public String hi() {
		return "Hello Welcome";
	}
	
	@GetMapping("/java")
	public String display() {
		return "Hello Welcome to java";
	}
	
	

}
