package com.zampro.banco.cuenta.services.cliente;

import com.zampro.banco.cuenta.entities.Cliente;

public interface IClienteService {
	
	public Cliente getCliente(long idCliente);
	
	public void setCliente(Cliente c);

}
