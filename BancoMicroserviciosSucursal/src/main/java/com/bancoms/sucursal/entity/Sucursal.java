package com.bancoms.sucursal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name= "sucursal")
public class Sucursal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String nombre;
	private String direccion;
	private String codigo;
	private String ciudad;
	private String provincia;
	
	public Sucursal() {
		super();
	}
	
	public Long getId() { return Id;}
	public void setId(Long id) { Id = id;}
	
	public String getNombre() {	return nombre;}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() { return direccion;}
	public void setDireccion(String direccion) {this.direccion = direccion;
	}
	public String getCodigo() {	return codigo;}
	public void setCodigo(String codigo) {this.codigo = codigo;	}
	
	public String getCiudad() {	return ciudad;}
	public void setCiudad(String ciudad) {this.ciudad = ciudad;	}
	
	public String getProvincia() { return provincia;}
	public void setProvincia(String provincia) { this.provincia = provincia;}
	
	
	
}
