package com.zampro.banco.cuenta.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zampro.banco.cuenta.entities.Cliente;
import com.zampro.banco.cuenta.exceptions.ErrorMicroExterno;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Value("${micro.cliente.url}")
	private String urlCliente; 
	
	@Override
	public Cliente getCliente(long idCliente) {		
		try {
			ResponseEntity<Cliente> resp = new RestTemplate().getForEntity(urlCliente + idCliente, Cliente.class);
			
			if (resp.getStatusCode() == HttpStatus.OK)
				return resp.getBody();
			else
				return null;
		
		} catch (Exception e) {
				throw new ErrorMicroExterno(e.getMessage());
		}
	}

	@Override
	public void setCliente(Cliente c) {
		try {
			new RestTemplate().put(urlCliente + c.getId(), c);
		} catch (Exception e) {
			throw new ErrorMicroExterno(e.getMessage());
		}
	}

}
