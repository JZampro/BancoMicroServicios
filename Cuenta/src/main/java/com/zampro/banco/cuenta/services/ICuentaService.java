package com.zampro.banco.cuenta.services;

import com.zampro.banco.cuenta.entities.Cuenta;

public interface ICuentaService {
	
	public Cuenta buscar(long id);
	
	public Cuenta alta(long idCliente);
	
	public Cuenta modificar(Cuenta c);
	
	public void baja(long id);

}
