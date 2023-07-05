package com.apni_dukan.services;


import java.util.List;
import java.util.Map;

import com.apni_dukan.models.Cart;
import com.apni_dukan.models.Product;
import com.apni_dukan.models.User;


public interface UserService {

	public User registerUser(User userDetails);
	
	public List<Product> getProductByName(String name);
	
	public Cart addToCart(Product product);
	
	public Map<String,Product> buyProduct(Product product);

	

}
