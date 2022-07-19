package com.zampro.banco.liquidarHaberes.services;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zampro.banco.liquidarHaberes.entities.Transaction;

@Service
public class HaberesService {
	
	static Logger logger = LoggerFactory.getLogger(HaberesService.class);
	
	private List<Transaction> listaTrasacciones = new ArrayList<>();
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	Queue cola;
	
	@Value("${micro.transaccion.url}")
	String urlBroker;
	
	public void getColaHaberes() {
		String resp = null;

		do {
			try {
				logger.info("Recibiendo mensajes de cola:");
				jmsTemplate.setReceiveTimeout(5000);
				resp = (String) jmsTemplate.receiveAndConvert(cola);
				
				ObjectMapper mapper = new ObjectMapper();
				Transaction t = mapper.convertValue(resp, Transaction.class);
				
				listaTrasacciones.add(t);
				logger.info(t.toString());
			} catch (Exception e) {
				logger.error(e.getMessage());
				resp = null;
			}
		} while (resp != null);
	}
	
	public List<Transaction> procesarTransferencias(){
		List<Transaction> listaProcesada = new ArrayList<>();
		for (Transaction t : listaTrasacciones) {
			logger.info("Procesando: " + t.toString());
			
			try {
				ResponseEntity<Transaction> resp = new RestTemplate().postForEntity(urlBroker, t, Transaction.class);
				
				if (resp.getStatusCode() == HttpStatus.OK)
					listaProcesada.add(resp.getBody());
				
			} catch (Exception e) {
				logger.info(e.getMessage());
				// crear lista de no procesados
			}
		}
		return listaProcesada;
	}

}
