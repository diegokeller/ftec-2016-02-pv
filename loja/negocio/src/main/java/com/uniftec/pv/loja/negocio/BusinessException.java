package com.uniftec.pv.loja.negocio;

/**
 * Exceção da camada de negócio. Indica algum erro ou validação.
 */
public class BusinessException extends Exception {

	public BusinessException(String message, Throwable cause) {
		super(message + (": " + cause != null ? cause.getMessage() : ""), cause);
	}

	public BusinessException(String message) {
		super(message);
	}

}
