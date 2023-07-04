package com.apni_dukan.services;


import java.util.List;

import com.apni_dukan.models.Cart;
import com.apni_dukan.models.Product;
import com.apni_dukan.models.User;


public interface UserService {

	public User registerUser(User userDetails);
	
	public List<Product> getProductByName(String name);
	
	public Cart addToCart(Product product);
	
	public Product buyProduct(Product product);

	

}
