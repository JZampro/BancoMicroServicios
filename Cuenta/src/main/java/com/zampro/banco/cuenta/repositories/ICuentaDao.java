package com.zampro.banco.cuenta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zampro.banco.cuenta.entities.Cuenta;

@Repository
public interface ICuentaDao extends JpaRepository<Cuenta, Long> {

}
