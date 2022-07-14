package com.zampro.banco.cuenta.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CuentaNoEncontrada extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CuentaNoEncontrada(long idCuenta) {
		super("La cuenta " + idCuenta + " no existe!");
	}
	
	
}
