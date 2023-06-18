package com.apni_dukan.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class UserLoginCred {

	private String email;
	private String password;
}
