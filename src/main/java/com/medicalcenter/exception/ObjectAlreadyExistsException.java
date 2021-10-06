package com.medicalcenter.exception;

public class ObjectAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectAlreadyExistsException(String mensagem) {
		super(mensagem);
	}
	
	public ObjectAlreadyExistsException(String mensagem, Throwable cause) {
		super(mensagem, cause);
	}

}
