package com.assignment.project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {
	
	 @ExceptionHandler(value = CustomException.class)
	    public final ResponseEntity<String> handleUpdateFailException(CustomException exception){
	        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	 
	 
	 @ExceptionHandler(value=AuthenticationfailedException.class)
	 public final ResponseEntity<String> handleAuthenticationfailedException(AuthenticationfailedException exception){
		 return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	 }
	 
	 @ExceptionHandler(value = ProductNotexsistException.class)
	 public final ResponseEntity<String> handleProductNotExsistException(ProductNotexsistException exception){
		 return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	 }

}
