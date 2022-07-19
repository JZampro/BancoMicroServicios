package com.juan.serviciopagoproducer.controller;

import com.juan.serviciopagoproducer.dto.Cliente;
import com.juan.serviciopagoproducer.service.CuentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/produce")
public class CuentasController {

    @Autowired
    CuentasService cuentasService;


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
    public Cliente[] enviarCuentas(@PathVariable("id") Long empresaId) {

        return cuentasService.enviarCuentas(empresaId);
    }

    @GetMapping("/message")
    public String hola() {
        return "Hola";
    }
}
