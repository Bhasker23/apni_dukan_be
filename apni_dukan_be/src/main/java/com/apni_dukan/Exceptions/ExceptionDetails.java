package com.apni_dukan.Exceptions;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExceptionDetails {
	
	private String message;
	private String discription;
	private LocalDate date;
}
