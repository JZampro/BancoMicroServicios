package com.zampro.banco.cuenta.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zampro.banco.cuenta.entities.Cliente;
import com.zampro.banco.cuenta.exceptions.ClienteNoEncontrado;
import com.zampro.banco.cuenta.exceptions.ErrorMicroExterno;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Value("${micro.cliente.url}")
	private String urlCliente; 
	
	@Override
	public Cliente getCliente(long idCliente) {
		ResponseEntity<Cliente> resp = null;
		
		try {
			resp = new RestTemplate().getForEntity(urlCliente + idCliente, Cliente.class);
		} catch (Exception e) {
			throw new ErrorMicroExterno("El microservicio de cliente no se encuentar disponible.");
		}
		
		if (resp.getStatusCode() == HttpStatus.OK)
			return resp.getBody();
		else if(resp.getStatusCode() == HttpStatus.NOT_FOUND)
			throw new ClienteNoEncontrado("El cliente " + idCliente + " no existe.");
		else
			throw new ErrorMicroExterno("El microservicio de cliente no se encuentar disponible.");
	}

	@Override
	public void setCliente(Cliente c) {
		new RestTemplate().put(urlCliente + c.getId(), c);
	}

}
