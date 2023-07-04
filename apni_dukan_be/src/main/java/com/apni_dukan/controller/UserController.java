package com.apni_dukan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apni_dukan.models.Cart;
import com.apni_dukan.models.Product;
import com.apni_dukan.models.User;
import com.apni_dukan.services.AdminService;
import com.apni_dukan.services.UserService;
import com.google.protobuf.Method;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> userRegistration(@RequestBody User userDetails){
		
		log.info("UserRegistration method calls");
		return new ResponseEntity<User>(userService.registerUser(userDetails),HttpStatus.CREATED);
	}
	
	@GetMapping("/getProduct")
	public ResponseEntity<List<Product>> getProductByName(String name){
		
		log.info("getProductByName Method called");
		
		return new ResponseEntity<List<Product>>(userService.getProductByName(name), HttpStatus.OK);
	}
	
	@PostMapping("/addToCart")
	public ResponseEntity<Cart> addToCart(@RequestBody Product product){
		
		log.info("addToCart method called");
		
		return new ResponseEntity<Cart>(userService.addToCart(product),HttpStatus.CREATED);
	}
}
