package com.bancoms.sucursal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bancoms.sucursal.entity.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal,Long> {
	
}
