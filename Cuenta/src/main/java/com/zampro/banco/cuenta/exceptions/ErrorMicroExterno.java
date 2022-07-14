package com.zampro.banco.cuenta.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE)
public class ErrorMicroExterno extends RuntimeException {

	public ErrorMicroExterno(String message) {
		super(message);
	}
}
