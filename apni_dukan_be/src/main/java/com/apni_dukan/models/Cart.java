package com.apni_dukan.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cart {

	@Id
	private int id ;
	private String name;
	private int price;
	private String description;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Product> carProduct = new ArrayList<>();
}
