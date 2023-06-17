package com.apni_dukan.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apni_dukan.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User findByMobileNumber(String mobileNumber);
}
