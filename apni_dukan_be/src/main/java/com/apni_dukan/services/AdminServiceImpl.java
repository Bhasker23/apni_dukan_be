package com.apni_dukan.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apni_dukan.Exceptions.AdminExection;
import com.apni_dukan.Exceptions.ProductException;
import com.apni_dukan.Repo.AdminRepo;
import com.apni_dukan.Repo.CartRepo;
import com.apni_dukan.Repo.ProductRepo;
import com.apni_dukan.models.Admin;
import com.apni_dukan.models.Cart;
import com.apni_dukan.models.Product;


@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepo adminDb;
	
	@Autowired
	private ProductRepo productDb;
	
	@Autowired
	private CartRepo cartDb;
	
	
	@Override
	public Admin registerAdmin(Admin admin) {
		
		if(adminDb.findByMobileNumber(admin.getMobileNumber()) != null) {
			throw new AdminExection(admin.getName() + " your account is already created with this mobile number ");
		}	
		Admin registeredAdmin = adminDb.save(admin);
		return registeredAdmin;
	}

	@Override
	public String uploadProduct(Product productbody) {
		
//		login and signup execption has to be checked or if this api's are authenticated and authorized
		
		if (productDb.findById(productbody.getId()).isPresent()) {
			throw new ProductException("Product Id "+productbody.getId() + " is already present in database, change the product id");
		}
		
		Product savedProduct = productDb.save(productbody);
		
		return savedProduct.getName()+ " has been uploaded";
	}

	@Override
	public List<Product> getAllProducts() {
		
//		login and signup execption has to be checked or if this api's are authenticated and authorized
		
		List<Product> list = productDb.findAll();
		
		if (list.size() == 0) {
			throw  new ProductException("OOPS! Your Product List is Empty.");
		}
		System.out.println(list);
		return list;
	}

	@Override
	public Map<String, Product> deleteProduct(int id) {
		
		List<Product> list = productDb.findAll();
		
		if (list.size() == 0) {
			throw  new ProductException("OOPS! Your Product List is Empty.");
		}
		
		if (productDb.findById(id) == null) {
			throw new ProductException("Given Product id is not availble in database");
		}
		
		Map<String, Product> map = new HashMap<>();
		Product deletedProduct = productDb.findById(id).get();
		productDb.delete(deletedProduct);
		String name = deletedProduct.getName();
		map.put(name+" has been deleted ", deletedProduct);
		return map;
	}

	@Override
	public Map<String, Product> updateProduct(int id, Product updatedProduct){
		
		List<Product> list = productDb.findAll();
		
		if (list.size() == 0) {
			throw  new ProductException("OOPS! Your Product List is Empty.");
		}
		if (productDb.findById(id) == null) {
			throw new ProductException("Given Product id is not availble in database");
		}
		
		
		Product oldProduct = productDb.findById(id).get();
		oldProduct.setName(updatedProduct.getName());
		oldProduct.setPrice(updatedProduct.getPrice());
		oldProduct.setDescription(updatedProduct.getDescription());
		productDb.save(oldProduct);
		Map<String, Product> map = new HashMap<>();
		map.put("Product updated with given Product ",oldProduct);
		
		if (cartDb.findById(id).isPresent()) {
			
			Cart cartProduct = cartDb.getById(id);
			cartProduct.setName(updatedProduct.getName());
			cartProduct.setPrice(updatedProduct.getPrice());
			cartProduct.setDescription(updatedProduct.getDescription());
			cartDb.save(cartProduct);
		}
		
		return map;
	}
	
	
}
