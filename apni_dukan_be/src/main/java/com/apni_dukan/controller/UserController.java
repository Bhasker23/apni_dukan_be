package com.apni_dukan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apni_dukan.models.User;
import com.apni_dukan.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("register")
	public ResponseEntity<User> userRegistration(@RequestBody User userDetails){
		
		return new ResponseEntity<User>(userService.registerUser(userDetails),HttpStatus.CREATED);
	}
}
