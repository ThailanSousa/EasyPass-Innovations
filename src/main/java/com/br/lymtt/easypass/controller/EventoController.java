package com.br.lymtt.easypass.controller;

import com.br.lymtt.easypass.entity.Event;
import com.br.lymtt.easypass.repository.EventRepository;
import com.br.lymtt.easypass.model.entities.Evento;
import com.br.lymtt.easypass.model.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private EventRepository eventRepository;

    // Endpoints padrão para Evento usando EventoService

    // CADASTRAR
    @PostMapping
    public ResponseEntity<Evento> cadastrar(@RequestBody Evento evento) {
        Evento novoEvento = eventoService.cadastrar(evento);
        return ResponseEntity.ok(novoEvento);
    }

    // LISTAR
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

    // ATUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizar(@PathVariable Long id, @RequestBody Evento evento) {
        Evento eventoAtualizado = eventoService.atualizar(id, evento);
        if (eventoAtualizado != null) {
            return ResponseEntity.ok(eventoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (eventoService.deletar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoints legacy para Event usando EventRepository

    @GetMapping("/legacy")
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/legacy/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            return ResponseEntity.ok(event.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/legacy")
    public Event createEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @PutMapping("/legacy/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            event.setNome(eventDetails.getNome());
            event.setLocal(eventDetails.getLocal());
            event.setData(eventDetails.getData());
            Event updatedEvent = eventRepository.save(event);
            return ResponseEntity.ok(updatedEvent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/legacy/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            eventRepository.delete(event.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
