package com.juan.serviciopagoproducer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juan.serviciopagoproducer.dto.Cliente;
import com.juan.serviciopagoproducer.dto.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.jms.Queue;

@Service
public class CuentasService {

    @Value("${service.cliente.uri}")
    private String uriCliente;
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Queue queue;
    public Cliente[] enviarCuentas(Long empresaId) {

        ResponseEntity<Cliente[]> response =
                restTemplate.getForEntity(uriCliente + empresaId,
                        Cliente[].class);

        Cliente[] clientes = response.getBody();

        try {

            ObjectMapper mapper = new ObjectMapper();

            for (Cliente cliente: clientes) {

                Transaction transaction = new Transaction();

                transaction.setDetail("Pago sueldos");
                transaction.setOriginAccount(7L);
                transaction.setDestinationAccount(cliente.getCuentaId());
                transaction.setAmount(10D);
                transaction.setIdAccount(cliente.getCuentaId());
                transaction.setTypeTransaction(1);


                String clienteAsJson = mapper.writeValueAsString(transaction);

                jmsTemplate.convertAndSend(queue, clienteAsJson);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientes;
    }
}

