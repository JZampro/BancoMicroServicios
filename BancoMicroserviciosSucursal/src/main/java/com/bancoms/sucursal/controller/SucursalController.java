package com.bancoms.sucursal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancoms.sucursal.entity.Sucursal;
import com.bancoms.sucursal.service.SucursalService;

@RestController
@RequestMapping("/apisucursal")
public class SucursalController {

	@Autowired
	private SucursalService sucursalService;
	
	@GetMapping("/allsucursal")
	public List<Sucursal> list(){
		return sucursalService.listAll();
	}
	
	@PostMapping("/addsucursal")
	public String add(@RequestBody Sucursal sucursal) {
		sucursalService.alta(sucursal);
		return "Sucursal agregada";
	}

}
