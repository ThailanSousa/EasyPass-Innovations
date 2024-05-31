package com.br.lymtt.easypass.model.repository;

import com.br.lymtt.easypass.model.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
