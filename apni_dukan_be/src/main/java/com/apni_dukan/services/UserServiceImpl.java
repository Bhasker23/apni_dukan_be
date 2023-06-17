package com.apni_dukan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apni_dukan.Exceptions.UserException;
import com.apni_dukan.Repo.UserRepo;
import com.apni_dukan.models.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userDb;
	@Override
	public User registerUser(User userDetails) {
		
		if(userDb.findByMobileNumber(userDetails.getMobileNumber()) != null) {
			throw new UserException(userDetails.getName()+" your account has already created. ");
		}
		
		User registerdUser = userDb.save(userDetails); 
		return registerdUser;
	}

}
