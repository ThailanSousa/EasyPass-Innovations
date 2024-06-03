package com.br.lymtt.easypass.controller;

import com.br.lymtt.easypass.entity.Promoter;
import com.br.lymtt.easypass.repository.PromoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/promoters")
public class PromotorController {

    @Autowired
    private PromoterRepository promoterRepository;

    @GetMapping
    public List<Promoter> getAllPromoters() {
        return promoterRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promoter> getPromoterById(@PathVariable String id) {
        Optional<Promoter> promoter = promoterRepository.findById(id);
        if (promoter.isPresent()) {
            return ResponseEntity.ok(promoter.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Promoter createPromoter(@RequestBody Promoter promoter) {
        return promoterRepository.save(promoter);
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
            Promoter updatedPromoter = promoterRepository.save(promoter);
            return ResponseEntity.ok(updatedPromoter);
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
}
