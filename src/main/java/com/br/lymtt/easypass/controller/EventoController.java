package com.br.lymtt.easypass.controller;

import com.br.lymtt.easypass.model.entities.Evento;
import com.br.lymtt.easypass.model.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    //CADASTRAR
    @PostMapping
    public ResponseEntity<Evento> cadastrar(@RequestBody Evento evento) {
        Evento novoEvento = eventoService.cadastrar(evento);
        return ResponseEntity.ok(novoEvento);
    }

    //LISTAR
    @GetMapping
    public ResponseEntity<List<Evento>> listar() {
        List<Evento> eventos = eventoService.listar();
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> listarPorId(@PathVariable Long id) {
        return eventoService.listarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //ATUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizar(@PathVariable Long id, @RequestBody Evento evento) {
        Evento eventoAtualizado = eventoService.atualizar(id, evento);
        if (eventoAtualizado != null) {
            return ResponseEntity.ok(eventoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (eventoService.deletar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
