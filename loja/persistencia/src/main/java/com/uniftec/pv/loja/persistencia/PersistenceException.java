package com.uniftec.pv.loja.persistencia;

/**
 * Exceção genérica da camada de persistência. Pode indicar erro de conexão,
 * SQL, FK, PK
 */
public class PersistenceException extends Exception {

	public PersistenceException(String message, Throwable cause) {
		super(message, cause);
	}

}
