package com.apni_dukan.models;


import lombok.Data;


@Data
public class User {
	
	private int uId;	
	private String name;
	private String email;
	private String password;
	private String mobileNumber;
}