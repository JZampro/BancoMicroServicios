package com.banco.transactions.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BadRequest extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BadRequest(long idCuenta) {
        super("No se encontro ningún registro");
    }

}
