package com.zampro.banco.cuenta.services;

import com.zampro.banco.cuenta.entities.Cliente;

public interface IClienteService {
	
	public Cliente getCliente(long idCliente);
	
	public void setCliente(Cliente c);

}
