package com.apni_dukan.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class AdminLoginCred {
	
	private String email;
	private String password;
	
}
