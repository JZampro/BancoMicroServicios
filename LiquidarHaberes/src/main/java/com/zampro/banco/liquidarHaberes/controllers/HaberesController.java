package com.zampro.banco.liquidarHaberes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zampro.banco.liquidarHaberes.services.HaberesService;

@RestController
@RequestMapping("/haberes")
public class HaberesController {
	
	@Autowired
	HaberesService haberesServicio;
	
	@GetMapping("/liquidar")
	public List<Object> liquidarHaberes() {
		haberesServicio.getColaHaberes();
		return haberesServicio.procesarTransferencias();
	}

}
