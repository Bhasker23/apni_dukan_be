package com.apni_dukan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apni_dukan.Exceptions.AdminExection;
import com.apni_dukan.Repo.AdminRepo;
import com.apni_dukan.models.Admin;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepo adminDb;
	
	@Override
	public Admin registerAdmin(Admin admin) {
		
		if(adminDb.findByMobileNumber(admin.getMobileNumber()) != null) {
			throw new AdminExection(admin.getName() + " your account is already created ");
		}	
		Admin registeredAdmin = adminDb.save(admin);
		return registeredAdmin;
	}
	
	
}
