package com.br.lymtt.easypass.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.lymtt.easypass.model.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
