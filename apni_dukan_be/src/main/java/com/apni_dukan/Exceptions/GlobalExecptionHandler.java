package com.apni_dukan.Exceptions;

import java.time.LocalDate;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExecptionHandler {

	@ExceptionHandler(AdminExection.class)
	public ResponseEntity<ExceptionDetails> adminRegisterException(AdminExection ae, WebRequest wr){
		
		ExceptionDetails ex = new ExceptionDetails();
		ex.setMessage(ae.getMessage());
		ex.setDiscription(wr.getDescription(false));
		ex.setDate(LocalDate.now());
		
		return new ResponseEntity<>(ex,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ExceptionDetails> userRegisterException(UserException ue, WebRequest wr){
		
		ExceptionDetails ex = new ExceptionDetails();
		ex.setMessage(ue.getMessage());
		ex.setDiscription(wr.getDescription(false));
		ex.setDate(LocalDate.now());
		
		return new ResponseEntity<>(ex,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<ExceptionDetails> productDeletionException(ProductException pe, WebRequest wr){
		
		
		ExceptionDetails ex = new ExceptionDetails();
		ex.setMessage(pe.getMessage());
		ex.setDiscription(wr.getDescription(false));
		ex.setDate(LocalDate.now());
		
		return new ResponseEntity<ExceptionDetails>(ex, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDetails> globalException(AdminExection ae, WebRequest wr){
		
		ExceptionDetails ex = new ExceptionDetails();
		ex.setMessage(ae.getMessage());
		ex.setDiscription(wr.getDescription(false));
		ex.setDate(LocalDate.now());
		
		return new ResponseEntity<>(ex,HttpStatus.BAD_REQUEST);
	}
}
