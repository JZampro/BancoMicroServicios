package com.juan.serviciopagoproducer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juan.serviciopagoproducer.dto.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.jms.Queue;

@Service
public class CuentasService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Queue queue;
    public Cliente[] enviarCuentas(Long empresaId) {

        ResponseEntity<Cliente[]> response =
                restTemplate.getForEntity("http://localhost:9002/clientes/empresa/" + empresaId,
                        Cliente[].class);

        Cliente[] clientes = response.getBody();

        try {
            ObjectMapper mapper = new ObjectMapper();

            for (Cliente cliente: clientes) {
                String clienteAsJson = mapper.writeValueAsString(cliente.getCuentaId());

                jmsTemplate.convertAndSend(queue, clienteAsJson);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientes;
    }
}
