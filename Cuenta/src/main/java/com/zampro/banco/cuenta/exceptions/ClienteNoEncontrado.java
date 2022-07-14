package com.zampro.banco.cuenta.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ClienteNoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClienteNoEncontrado(String message) {
		super(message);
	}
}
