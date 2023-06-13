package com.apni_dukan.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apni_dukan.models.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {

}
