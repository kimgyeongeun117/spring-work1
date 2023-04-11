package com.example.demo3.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.dto.User;

@RestController("/api")
public class UserController {

	@PostMapping("/user")
	public String user(@RequestBody User user) {
	
		User user2 = new User();
		
		return null;
	}
}
