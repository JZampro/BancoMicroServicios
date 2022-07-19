package com.zampro.banco.cuenta.services.transaccion;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.zampro.banco.cuenta.entities.Cuenta;
import com.zampro.banco.cuenta.entities.Transaction;
import com.zampro.banco.cuenta.exceptions.ErrorMicroExterno;
import com.zampro.banco.cuenta.services.cuenta.ICuentaService;

@Service
public class TransaccionServiceImpl implements ITransaccionService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${micro.transaccion.url}")
	private String urlTransaccion;
	
	@Autowired
	private ICuentaService cuentaService;
	
	@Override
	public boolean verificarSaldo(Transaction t) {
		Cuenta origen = cuentaService.buscar(t.getOriginAccount());
		
		if (origen.getSaldo().compareTo(BigDecimal.valueOf(t.getAmount())) >= 0)
			return true;
		else
			return false;
	}

	@Override
	@Transactional()
	public void modificarSaldos(Transaction t) {
		Cuenta origen = cuentaService.buscar(t.getOriginAccount());
		Cuenta destino = cuentaService.buscar(t.getDestinationAccount());
		
		origen.setSaldo(
				origen.getSaldo().subtract(
						BigDecimal.valueOf(t.getAmount()))); 
		
		destino.setSaldo(
				destino.getSaldo().add(
						BigDecimal.valueOf(t.getAmount())));
		
		cuentaService.modificar(origen);
		cuentaService.modificar(destino);
	}

	@Override
	public void enviarMovimiento(Transaction t) {
		t.setDate(new Date());
		
		try {
			ResponseEntity<Transaction> resp = new RestTemplate().postForEntity(urlTransaccion, t, Transaction.class);
			
			if (resp.getStatusCode() == HttpStatus.OK)
				t.setId(resp.getBody().getId());
			
		} catch (Exception e) {
			throw new ErrorMicroExterno(e.getMessage());
		}
	}

}
