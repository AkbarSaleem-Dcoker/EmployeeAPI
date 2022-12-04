package com.employee.api.exception;

import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  public ResponseEntity<String> handleNoSuchElementFoundException(
			  NoSuchElementException exception
	  ) {
	    return ResponseEntity
	        .status(HttpStatus.NOT_FOUND)
	        .body(exception.getMessage());
	  }
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  public ResponseEntity<String> handleEmptyResultDataAccessException(
			  EmptyResultDataAccessException exception
	  ) {
	    return ResponseEntity
	        .status(HttpStatus.NOT_FOUND)
	        .body(exception.getMessage());
	  }

}
