package com.apni_dukan.services;


import java.util.List;
import java.util.Map;

import com.apni_dukan.models.Admin;
import com.apni_dukan.models.Product;

public interface AdminService {
	
	public Admin registerAdmin(Admin admin);
	
	public String uploadProduct(Product productbody);
	
	public List<Product> getAllProducts();
	
	public Map<String, Product> deleteProduct(int id);
	
	public Map<String, Product> updateProduct(int id, Product updatedProduct);
	
}
