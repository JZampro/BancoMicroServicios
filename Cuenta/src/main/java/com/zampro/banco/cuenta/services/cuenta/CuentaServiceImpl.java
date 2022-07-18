package com.zampro.banco.cuenta.services.cuenta;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zampro.banco.cuenta.entities.Cliente;
import com.zampro.banco.cuenta.entities.Cuenta;
import com.zampro.banco.cuenta.exceptions.CuentaNoEncontrada;
import com.zampro.banco.cuenta.repositories.ICuentaDao;
import com.zampro.banco.cuenta.services.cliente.IClienteService;

@Service
public class CuentaServiceImpl implements ICuentaService {

	@Autowired
	private ICuentaDao dao;
	
	@Autowired
	private IClienteService microCliente;
	
	@Override
	@Transactional(readOnly = false)
	public Cuenta buscar(long id) {		
		Cuenta c = dao.findById(id).orElse(null);
		
		if (c != null)
			return c;
		else
			throw new CuentaNoEncontrada(id);
	}
	
	@Override
	@Transactional
	public Cuenta alta(long idCliente) {
		Cliente cliente = microCliente.getCliente(idCliente);
		
		Cuenta cuenta = dao.save(new Cuenta("Caja de Ahorros", "Caja de Ahorros A"));
		
		cliente.setCuentaId(cuenta.getId());
		
		microCliente.setCliente(cliente);
				
		return cuenta;
	}

	@Override
	@Transactional()
	public Cuenta modificar(Cuenta c) {
		Optional<Cuenta> cuenta = dao.findById(c.getId());
		
		if (!cuenta.isEmpty())
			return dao.save(c);
		else
			throw new CuentaNoEncontrada(c.getId());
	}

	@Override
	@Transactional
	public void baja(long id){
		Cuenta c = dao.findById(id).orElse(null);
		
		if (c != null) {
			c.setActiva(false);
		} else
			throw new CuentaNoEncontrada(id);
			
	}

}
