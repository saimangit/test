package com.test.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/admin")
	public String admin() {
	   return "Hello Admin";	
	}
	@GetMapping("/user")
	public String user() {
		   return "Hello user";	
		}
	@GetMapping("/")
	public String all() {
	   return "Hello All";	
	}
}

