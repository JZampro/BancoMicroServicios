package com.zampro.banco.cuenta.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Transaccion {
	
	private long id;
	private long cuentaOrigen;
	private long cuentaDestino;
	
	private int tipoMovimiento;
	private String detalle;
	private Date fecha;
	
	private BigDecimal monto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(long cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	public long getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(long cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}

	public int getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(int tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
}
