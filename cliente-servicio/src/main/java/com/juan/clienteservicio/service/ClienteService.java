package com.juan.clienteservicio.service;

import com.juan.clienteservicio.models.ResponseTemplate;
import com.juan.clienteservicio.models.Sucursal;
import com.juan.clienteservicio.entity.Cliente;
import com.juan.clienteservicio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RestTemplate restTemplate;

    //@Value("${uri_service_sucursal}")
    private String uriProperty;

    public List<Cliente> findAll() {

        return clienteRepository.findAll();
    }

    public List<Cliente> findByEmpresaId(Long empresaId) {

        return clienteRepository.findByEmpresaId(empresaId);
    }

    public Cliente saveCliente(Cliente cliente) {

        Long idSucursal =
                restTemplate.getForObject("http://localhost:9001/sucursales/unasucursal",
                        Long.class);
        cliente.setSucursalId(idSucursal);
        return clienteRepository.save(cliente);
    }



    public ResponseTemplate getClienteWithSucursal(Long clienteId) {

        ResponseTemplate responseTemplate = new ResponseTemplate();
        Cliente cliente = clienteRepository.findById(clienteId).get();

        Sucursal sucursal =
                restTemplate.getForObject("http://localhost:9001/sucursales/" + cliente.getSucursalId(),
                        Sucursal.class);


        responseTemplate.setCliente(cliente);
        responseTemplate.setSucursal(sucursal);

        return responseTemplate;
    }


    public Cliente findById(Long clienteId) {

        return clienteRepository.findById(clienteId).get();
    }
}
