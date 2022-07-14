package com.juan.clienteservicio.entity;


import javax.persistence.*;

@Entity(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",
            updatable = false
    )
    private Long id;

    @Column(name = "nombre",
            nullable = false
    )
    private String nombre;

    @Column(name = "apellido",
            nullable = false
    )
    private String apellido;

    @Column(name = "email",
            nullable = false,
            unique = true
    )
    private String email;

    @Column(name = "num_doc",
            nullable = false,
            unique = true
    )
    private String numDoc;

    @Column(name = "sucursalId")
    private Long sucursalId;

    public Cliente() {
    }

    public Cliente(Long id, String nombre, String apellido, String email, String numDoc, Long sucursalId) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.numDoc = numDoc;
        this.sucursalId = sucursalId;
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


}