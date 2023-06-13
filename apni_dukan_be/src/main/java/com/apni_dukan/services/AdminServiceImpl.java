package com.apni_dukan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apni_dukan.Repo.AdminRepo;
import com.apni_dukan.models.Admin;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepo adminRepo;
	@Override
	public Admin registerAdmin(Admin admin) {
		
		Admin registeredAdmin = adminRepo.save(admin);
//		return "Your account has been created";
		return registeredAdmin;
	}
	
	
}
