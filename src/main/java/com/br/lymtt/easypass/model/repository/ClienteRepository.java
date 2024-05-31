package com.br.lymtt.easypass.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.br.lymtt.easypass.model.entities.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}