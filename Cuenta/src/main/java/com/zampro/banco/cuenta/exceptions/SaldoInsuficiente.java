package com.zampro.banco.cuenta.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class SaldoInsuficiente extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SaldoInsuficiente() {
		super("Saldo insuficiente para realizar la transaccion.");
	}

}
