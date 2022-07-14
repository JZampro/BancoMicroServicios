package com.juan.clienteservicio.models;

import com.juan.clienteservicio.entity.Cliente;

public class ResponseTemplate {

    private Cliente cliente;
    private Sucursal sucursal;

    public Cliente getCliente() {
        return cliente;
    }

    public ResponseTemplate() {

    }

    public ResponseTemplate(Cliente cliente, Sucursal sucursal) {
        this.cliente = cliente;
        this.sucursal = sucursal;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
