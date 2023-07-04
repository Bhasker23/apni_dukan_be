package com.apni_dukan.Repo;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apni_dukan.models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	List<Product> findByName(String name);

}