package com.br.lymtt.easypass.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.lymtt.easypass.model.entities.Evento;
import com.br.lymtt.easypass.model.service.EventoService;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    // ENDPOINT PARA LISTAR TODOS OS EVENTOS
    @GetMapping
    public ResponseEntity<List<Evento>> listarEventos() {
        List<Evento> eventos = eventoService.listarEventos();
        return ResponseEntity.ok(eventos);
    }

    // ENDPOINT PARA BUSCAR EVENTO POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarEventoPorId(@PathVariable Long id) {
        Optional<Evento> evento = eventoService.buscarEventoPorId(id);
        return evento.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // ENDPOINT PARA CADASTRAR UM NOVO EVENTO
    @PostMapping
    public ResponseEntity<Evento> cadastrarEvento(@RequestBody Evento evento) {
        Evento novoEvento = eventoService.salvarEvento(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEvento);
    }

    // ENDPOINT PARA DELETAR UM EVENTO POR ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEvento(@PathVariable Long id) {
        eventoService.deletarEvento(id);
        return ResponseEntity.noContent().build();
    }
}
