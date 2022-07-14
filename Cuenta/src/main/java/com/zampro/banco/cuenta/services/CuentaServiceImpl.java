package com.zampro.banco.cuenta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zampro.banco.cuenta.entities.Cuenta;
import com.zampro.banco.cuenta.exceptions.CuentaNoEncontrada;
import com.zampro.banco.cuenta.repositories.ICuentaDao;

@Service
public class CuentaServiceImpl implements ICuentaService {

	@Autowired
	ICuentaDao dao;
	
	@Override
	@Transactional(readOnly = false)
	public Cuenta buscar(long id) {
		return dao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Cuenta alta() {
		Cuenta c = new Cuenta("Caja de Ahorros", "Caja de Ahorros A");
		return dao.save(c);
	}

	@Override
	@Transactional
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
