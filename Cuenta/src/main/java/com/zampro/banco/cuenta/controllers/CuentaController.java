package com.zampro.banco.cuenta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zampro.banco.cuenta.entities.Cuenta;
import com.zampro.banco.cuenta.exceptions.CuentaNoEncontrada;
import com.zampro.banco.cuenta.services.ICuentaService;

@RestController
@RequestMapping(path = "/cuenta")
public class CuentaController {
	
	@Autowired
	ICuentaService cuentaServicio;
	
	@GetMapping(path = "/{id}")
	public Cuenta getCuenta(@PathVariable long id) {
		Cuenta c = cuentaServicio.buscar(id);
		
		if (c == null)
			throw new CuentaNoEncontrada(id);
		else
			return c;
	}
	
	@GetMapping(path = "/{id}/saldo")
	public String getSaldo(@PathVariable long id) {
		return cuentaServicio.buscar(id).getSaldo().toString();
	}
	
	@PostMapping(path = "/")
	public Cuenta altaCuenta() {
		return cuentaServicio.alta();
	}
	
	@PutMapping(path = "/{id}")
	public Cuenta modCuenta(@PathVariable long id, @RequestBody Cuenta c) {
			return cuentaServicio.modificar(c);
	}
	
	@DeleteMapping(path = "/{id}")
	public void bajaCuenta(@PathVariable long id) {
			cuentaServicio.baja(id);
	}

}
