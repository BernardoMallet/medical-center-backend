package com.medicalcenter.exception.handle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.medicalcenter.exception.BadRequestException;
import com.medicalcenter.exception.LoginException;
import com.medicalcenter.exception.ObjectAlreadyExistsException;
import com.medicalcenter.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<StandardError> loginException(LoginException e,
			HttpServletRequest request) {
		StandardError err = new StandardError(HttpStatus.UNAUTHORIZED.value(), e.getMessage(),
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
	}
	
	@ExceptionHandler(ObjectAlreadyExistsException.class)
	public ResponseEntity<StandardError> ObjectAlreadyExists(ObjectAlreadyExistsException e,
			HttpServletRequest request) {
		StandardError err = new StandardError(HttpStatus.CONFLICT.value(), e.getMessage(),
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
	}
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<StandardError> badRequestException(BadRequestException e, HttpServletRequest request) {
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
