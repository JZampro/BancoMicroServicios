package com.juan.serviciopagoproducer.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juan.serviciopagoproducer.dto.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.jms.Queue;
import java.util.List;

@RestController
@RequestMapping("/produce")
public class ProducerCuentas {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Queue queue;

   /* @PostMapping("/message")
    public Cliente sendMessage(@RequestBody Cliente cliente) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            String studentAsJson = mapper.writeValueAsString(cliente);

            jmsTemplate.convertAndSend(queue, studentAsJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }*/

    @PostMapping("/cuentas/{id}")
    public Cliente[] sendAcount(@PathVariable("id") Long empresaId) {


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

    @GetMapping("/message")
    public String hola() {
        return "Hola";
    }
}
