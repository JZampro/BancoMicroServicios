package com.zampro.banco.cuenta.services.transaccion;

import com.zampro.banco.cuenta.entities.Transaction;

public interface ITransaccionService {
	
	public boolean verificarSaldo(Transaction t);
	
	public void modificarSaldos(Transaction t);
	
	public void enviarMovimiento(Transaction t);

}
