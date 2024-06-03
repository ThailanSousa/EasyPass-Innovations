package com.br.lymtt.easypass.controller;


import com.br.lymtt.easypass.entity.Event;
import com.br.lymtt.easypass.entity.Promoter;
import com.br.lymtt.easypass.repository.EventRepository;
import com.br.lymtt.easypass.repository.PromoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/promoters")
public class PromotorController {

    @Autowired
    private PromoterRepository promoterRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    public ResponseEntity<?> getAllPromoters() {
        return ResponseEntity.ok(promoterRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promoter> getPromoterById(@PathVariable String id) {
        Optional<Promoter> promoter = promoterRepository.findById(id);
        return promoter.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Promoter> createPromoter(@RequestBody Promoter promoter) {
        return ResponseEntity.ok(promoterRepository.save(promoter));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promoter> updatePromoter(@PathVariable String id, @RequestBody Promoter promoterDetails) {
        Optional<Promoter> optionalPromoter = promoterRepository.findById(id);
        if (optionalPromoter.isPresent()) {
            Promoter promoter = optionalPromoter.get();
            promoter.setNome(promoterDetails.getNome());
            promoter.setIdade(promoterDetails.getIdade());
            promoter.setEmail(promoterDetails.getEmail());
            promoter.setCodigoPromotor(promoterDetails.getCodigoPromotor());
            return ResponseEntity.ok(promoterRepository.save(promoter));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromoter(@PathVariable String id) {
        Optional<Promoter> promoter = promoterRepository.findById(id);
        if (promoter.isPresent()) {
            promoterRepository.delete(promoter.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{promoterId}/events")
    public ResponseEntity<Event> createEvent(@PathVariable String promoterId, @RequestBody Event event) {
        Optional<Promoter> optionalPromoter = promoterRepository.findById(promoterId);
        if (optionalPromoter.isPresent()) {
            Promoter promoter = optionalPromoter.get();
            promoter.addEvent(event);
            eventRepository.save(event);
            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}