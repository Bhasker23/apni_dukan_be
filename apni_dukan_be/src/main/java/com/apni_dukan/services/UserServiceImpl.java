package com.apni_dukan.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apni_dukan.Exceptions.ProductException;
import com.apni_dukan.Exceptions.UserException;
import com.apni_dukan.Repo.CartRepo;
import com.apni_dukan.Repo.ProductRepo;
import com.apni_dukan.Repo.UserRepo;
import com.apni_dukan.models.Cart;
import com.apni_dukan.models.Product;
import com.apni_dukan.models.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userDb;
	
	@Autowired
	private ProductRepo productDb;
	
	@Autowired
	private CartRepo cartDb;
	
	@Override
	public User registerUser(User userDetails) {
		
		if(userDb.findByMobileNumber(userDetails.getMobileNumber()) != null) {
			throw new UserException(userDetails.getName()+" your account has already created. ");
		}
		
		User registerdUser = userDb.save(userDetails); 
		return registerdUser;
	}
	
	@Override
	public List<Product> getProductByName(String name) {
	
		if (productDb.findByName(name).isEmpty()) {
			throw new ProductException(name + " is not avaible in databases.");
		}
		List<Product> list = productDb.findByName(name);
				
		return list;
	}
	
	@Override
	public  Cart addToCart(Product product) {
		
		if (productDb.findByName(product.getName()).isEmpty()) {
			throw new ProductException(product.getName() + " is not avaible in databases.");
		}
		
		Cart productAddedToCart = new Cart();
		productAddedToCart.setId(product.getId());
		productAddedToCart.setName(product.getName());
		productAddedToCart.setPrice(product.getPrice());
		productAddedToCart.setDescription(product.getDescription());
		
		productAddedToCart.getCarProduct().add(product);
		return cartDb.save(productAddedToCart);
	}
	
	
	@Override
	public Map<String,Product> buyProduct(Product product) {
		
		Map<String, Product> map = new HashMap<>();
		
		map.put("Congrats, you have purchased new Item.", product);
		return map;
	}

}
