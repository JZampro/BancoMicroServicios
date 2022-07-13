package com.bancoms.sucursal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancoms.sucursal.entity.Sucursal;
import com.bancoms.sucursal.repository.SucursalRepository;

@Service
public class SucursalService {
	@Autowired 
	private SucursalRepository sucursalRepository;
	
	public List<Sucursal> listAll(){
		return sucursalRepository.findAll();
	}
	
	public Sucursal alta(Sucursal sucursal) {
		return sucursalRepository.save(sucursal);
	}
	
	//public Sucursal modifica(Sucursal sucursal) {
		//return sucursalRepository
	//}
	
}
