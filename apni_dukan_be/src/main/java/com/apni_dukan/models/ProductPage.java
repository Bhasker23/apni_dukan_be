package com.apni_dukan.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

public class ProductPage {
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Product> products;
}
