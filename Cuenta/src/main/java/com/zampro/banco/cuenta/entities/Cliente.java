package com.zampro.banco.cuenta.entities;

public class Cliente {
	
	private long id;
	private String nombre;
	private String apellido;
	private String email;
	private String numDoc;
	private long sucursalId;
	private long cuentaId;
	private boolean activo;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public long getSucursalId() {
		return sucursalId;
	}
	public void setSucursalId(long sucursalId) {
		this.sucursalId = sucursalId;
	}
	public long getCuentaId() {
		return cuentaId;
	}
	public void setCuentaId(long cuentaId) {
		this.cuentaId = cuentaId;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
