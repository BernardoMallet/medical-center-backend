package com.medicalcenter.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BadRequestException(String mensagem) {
		super(mensagem);
	}
	
	public BadRequestException(String mensagem, Throwable cause) {
		super(mensagem, cause);
	}

}
