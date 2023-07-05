package com.apni_dukan.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Cart {

	@Id
	private int id ;
	private String name;
	private int price;
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	@Transient
	private List<Product> carProduct = new ArrayList<>();
}
