package com.zampro.banco.liquidarHaberes.services;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class HaberesService {
	
	static Logger logger = LoggerFactory.getLogger(HaberesService.class);
	
	private List<Object> lista = new ArrayList<>();
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	Queue cola;
	
	public void getColaHaberes() {
		Object u = null;

		do {
			try {
				logger.info("Recibiendo mensajes de cola:");
				jmsTemplate.setReceiveTimeout(5000);
				u = jmsTemplate.receiveAndConvert(cola);
				lista.add(u);
				logger.info(u.toString());
			} catch (Exception e) {
				logger.error(e.getMessage());
				u = null;
			}
		} while (u != null);
	}
	
	public List<Object> procesarTransferencias(){
		for (Object o : lista) {
			logger.info("Procesando: " + o.toString());
			// LLamar al micro de trasferencias
			// acumulo las transferencias que me devuelve el micro y las devuelvo
		}
		return this.lista;
	}

}
