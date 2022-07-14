package com.zampro.banco.cuenta.services;

import com.zampro.banco.cuenta.entities.Cuenta;

public interface ICuentaService {
	
	public Cuenta buscar(long id);
	
	public Cuenta alta();
	
	public Cuenta modificar(Cuenta c) throws Exception;
	
	public void baja(long id) throws Exception;

}
