package com.juan.clienteservicio.controller;


import com.juan.clienteservicio.models.ResponseTemplate;
import com.juan.clienteservicio.entity.Cliente;
import com.juan.clienteservicio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public List<Cliente> getAllClientes(){
        return clienteService.findAll();
    }

    @PostMapping("/")
    public Cliente saveCliente(@RequestBody Cliente cliente){

        return clienteService.saveCliente(cliente);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long clienteId) {
        try {
            Cliente cliente = clienteService.findById(clienteId);
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);

        } catch(NoSuchElementException e) {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseTemplate getClienteWithSucursal(@PathVariable("id") Long clienteId){

        return clienteService.getClienteWithSucursal(clienteId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable("id") Long clienteId, @RequestBody Cliente detallesCliente) {

        try {
            Cliente cliente = clienteService.findById(clienteId);

            cliente.setEmail(detallesCliente.getEmail());
            cliente.setSucursalId(detallesCliente.getSucursalId());
            final Cliente updatedCliente = clienteService.saveCliente(cliente);
            return new ResponseEntity<Cliente>(updatedCliente, HttpStatus.OK);

        } catch(NoSuchElementException e) {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }

    }

}
