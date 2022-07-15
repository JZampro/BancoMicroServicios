package com.zampro.banco.cuenta.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE)
public class ErrorMicroExterno extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErrorMicroExterno(String message) {
		super("Error Recibido desde el micro Cliente: " + message);
	}
}
