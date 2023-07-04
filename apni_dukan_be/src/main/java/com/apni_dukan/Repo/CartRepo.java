package com.apni_dukan.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apni_dukan.models.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{

}
