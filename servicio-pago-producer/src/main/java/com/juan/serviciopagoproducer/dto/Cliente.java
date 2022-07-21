package com.juan.serviciopagoproducer.dto;

import java.io.Serializable;

public class Cliente {

        private Long id;
        private String nombre;
        private String apellido;
        private String email;
        private String numDoc;
        private Long sucursalId;
        private Long cuentaId;
        private Long empresaId;

        public Cliente() {
        }

        public Cliente(Long id, String nombre, String apellido, String email, String numDoc, Long sucursalId, Long cuentaId, Long empresaId) {
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.email = email;
            this.numDoc = numDoc;
            this.sucursalId = sucursalId;
            this.cuentaId = cuentaId;
            this.empresaId = empresaId;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNumDoc() {
            return numDoc;
        }

        public void setNumDoc(String numDoc) {
            this.numDoc = numDoc;
        }

        public Long getSucursalId() {
            return sucursalId;
        }

        public void setSucursalId(Long sucursalId) {
            this.sucursalId = sucursalId;
        }

        public Long getCuentaId() {
            return cuentaId;
        }

        public void setCuentaId(Long cuentaId) {
            this.cuentaId = cuentaId;
        }

        public Long getEmpresaId() {
            return empresaId;
        }

        public void setEmpresaId(Long empresaId) {
            this.empresaId = empresaId;
        }

}