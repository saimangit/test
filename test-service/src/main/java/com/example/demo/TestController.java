package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/admin")
	public String admin() {
	   return "Hello World";	
	}
	@GetMapping("/user")
	public String user() {
		   return "Hello user";	
		}
	@GetMapping("/guest")	
	public String guest() {
		   return "Hello guest";	
		}
		
}

