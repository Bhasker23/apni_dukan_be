package com.apni_dukan.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserLoginCred {

	private String email;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
}
