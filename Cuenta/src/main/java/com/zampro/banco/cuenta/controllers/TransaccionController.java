package com.zampro.banco.cuenta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zampro.banco.cuenta.entities.Transaction;
import com.zampro.banco.cuenta.exceptions.SaldoInsuficiente;
import com.zampro.banco.cuenta.services.transaccion.ITransaccionService;

@RestController
public class TransaccionController {
	
	@Autowired
	ITransaccionService transService;
	
	@PostMapping("/transaccion/")
	public Transaction realizarTransaccion(@RequestBody Transaction t) {
		if (transService.verificarSaldo(t)) {
			transService.enviarMovimiento(t);
			transService.modificarSaldos(t);
			return t;
		} else
			throw new SaldoInsuficiente();
	}

}
