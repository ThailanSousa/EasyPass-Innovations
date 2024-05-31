package com.br.lymtt.easypass.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.br.lymtt.easypass.model.entities.Evento;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{

}