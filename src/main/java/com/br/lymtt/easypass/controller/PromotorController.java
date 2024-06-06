package com.br.lymtt.easypass.controller;

import com.br.lymtt.easypass.model.entities.Promotor;
import com.br.lymtt.easypass.model.service.PromotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotores")
public class PromotorController {

    @Autowired
    private PromotorService promotorService;

    // Cadastrar
    @PostMapping
    public ResponseEntity<Promotor> cadastrar(@RequestBody Promotor promotor) {
        Promotor novoPromotor = promotorService.cadastrar(promotor);
        return ResponseEntity.ok(novoPromotor);
    }

    // Listar todos
    @GetMapping
    public ResponseEntity<List<Promotor>> listar() {
        List<Promotor> promotores = promotorService.listar();
        return ResponseEntity.ok(promotores);
    }

    // Listar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Promotor> listarPorId(@PathVariable Long id) {
        return promotorService.listarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Promotor> atualizar(@PathVariable Long id, @RequestBody Promotor promotor) {
        Promotor promotorAtualizado = promotorService.atualizar(id, promotor);
        if (promotorAtualizado != null) {
            return ResponseEntity.ok(promotorAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (promotorService.deletar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
