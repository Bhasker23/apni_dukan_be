package com.apni_dukan.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	private String name;
	private int price;
	private String desciption;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private ProductPage productPage;
	
}
