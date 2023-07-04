package com.apni_dukan.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apni_dukan.models.Admin;
import com.apni_dukan.models.Product;
import com.apni_dukan.services.AdminService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/register")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin adminDetails ){
		
		log.info("RegisterAdmin method calls");
		return new ResponseEntity<Admin>(adminService.registerAdmin(adminDetails), HttpStatus.CREATED);
		
	}
	
	@PostMapping("/uploadProduct")
	public ResponseEntity<String> uploadProduct(@RequestBody Product productBody){
		
		log.info("uploadProduct method calls");
		return new ResponseEntity<String>(adminService.uploadProduct(productBody),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllProduct")
	public ResponseEntity<List<Product>> getAllProduct(){
		
		log.info("getAllProduct method called");
		return new ResponseEntity<List<Product>>(adminService.getAllProducts(), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById")
	public ResponseEntity<Map<String, Product>> deleteProductById(@RequestParam int id){		
		
		log.info("deleteProductById method called");
		return new ResponseEntity<Map<String,Product>>(adminService.deleteProduct(id), HttpStatus.OK);
			
	}
	
	
	@PutMapping("/updateProduct")
	public ResponseEntity<Map<String, Product>> updatProductById(@RequestParam int id, @RequestBody Product updatedProduct){		
		
		log.info("updatProductById method called");
		return new ResponseEntity<Map<String,Product>>(adminService.updateProduct(id, updatedProduct), HttpStatus.OK);
			
	}
	
	
}
