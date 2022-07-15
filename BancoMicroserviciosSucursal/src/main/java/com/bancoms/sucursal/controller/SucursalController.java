package com.bancoms.sucursal.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancoms.sucursal.entity.Sucursal;
import com.bancoms.sucursal.service.SucursalService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/apisucursal")
public class SucursalController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SucursalService sucursalService;
	
	@GetMapping("/allsucursal")
	public List<Sucursal> list(){
		return sucursalService.listAll();
	}
	
	@PostMapping("/addsucursal")
	public String add(@RequestBody Sucursal sucursal) {
		sucursalService.alta(sucursal);
		log.info(sucursal.toString());
		return "Sucursal agregada";
	}

	@PutMapping("/editsucursal/{idsuc}")
		public ResponseEntity<?> actulizarSucu(@PathVariable("idsuc") Long idsuc, @RequestBody Sucursal sucursal) {
		if (!sucursalService.existeSucursal(idsuc)) {
	        return new ResponseEntity("No existe la sucursal", HttpStatus.NOT_FOUND);
		}
		if((sucursal.getCodigo()== null  || sucursal.getCodigo() =="" ))
            return new ResponseEntity("EL CODIGO DE sucursal es obligatorio", HttpStatus.BAD_REQUEST);
		
		Sucursal sucuedit = new Sucursal();
		sucuedit.setNombre(sucursal.getNombre());
		sucuedit.setCodigo(sucursal.getCodigo());
		sucuedit.setProvincia(sucursal.getProvincia());
		sucursalService.alta(sucuedit);
		return new ResponseEntity("Sucursal Actualizada!!!" , HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Sucursal> get(@PathVariable Long id) {
        try {
        	Sucursal sucursal = sucursalService.get(id);
            return new ResponseEntity<Sucursal>(sucursal, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Sucursal>(HttpStatus.NOT_FOUND);
        }
    }
	
	@GetMapping("/getsucursal")
	public String unasucu() {
		List<Sucursal> sucus = sucursalService.listAll();
		List<Long> lista1 = new ArrayList();
		for (int i = 0 ; i < sucus.size(); i++) {
			lista1.add(sucus.get(i).getId());
		}
		
		log.info(lista1.toString());
		
        Random aleatorio = new Random();
        Long r = lista1.get(aleatorio.nextInt(lista1.size()));
		return r.toString()  ;
	}
	
}
