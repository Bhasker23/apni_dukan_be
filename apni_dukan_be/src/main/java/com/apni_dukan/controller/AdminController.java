package com.apni_dukan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apni_dukan.models.Admin;
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
}
