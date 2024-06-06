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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.lymtt.easypass.model.entities.Promotor;
import com.br.lymtt.easypass.model.service.PromotorService;

@RestController
@RequestMapping("/api/promotores")
public class PromotorController {

    @Autowired
    private PromotorService promotorService;

    // ENDPOINT PARA LISTAR TODOS OS PROMOTORES
    @GetMapping
    public ResponseEntity<List<Promotor>> listarPromotores() {
        List<Promotor> promotores = promotorService.listarPromotores();
        return ResponseEntity.ok(promotores);
    }

    // ENDPOINT PARA BUSCAR PROMOTOR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Promotor> buscarPromotorPorId(@PathVariable Long id) {
        Optional<Promotor> promotor = promotorService.buscarPromotorPorId(id);
        return promotor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // ENDPOINT PARA CADASTRAR UM NOVO PROMOTOR
    @PostMapping
    public ResponseEntity<Promotor> cadastrarPromotor(@RequestBody Promotor promotor) {
        Promotor novoPromotor = promotorService.salvarPromotor(promotor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPromotor);
    }

    // ENDPOINT PARA DELETAR UM PROMOTOR POR ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPromotor(@PathVariable Long id) {
        promotorService.deletarPromotor(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para atualizar um promotor por ID
    @PutMapping("/{id}")
    public ResponseEntity<Promotor> atualizarPromotor(@PathVariable Long id, @RequestBody Promotor promotorAtualizado) {
        Promotor promotorExistente = promotorService.atualizarPromotor(id, promotorAtualizado);
        return ResponseEntity.ok(promotorExistente);
    }
}
