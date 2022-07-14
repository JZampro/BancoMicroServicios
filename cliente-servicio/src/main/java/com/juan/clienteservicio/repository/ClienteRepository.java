package com.juan.clienteservicio.repository;

import com.juan.clienteservicio.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
