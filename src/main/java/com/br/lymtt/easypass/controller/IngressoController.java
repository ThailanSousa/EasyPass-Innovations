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

import com.br.lymtt.easypass.model.entities.Ingresso;
import com.br.lymtt.easypass.model.service.IngressoService;

@RestController
@RequestMapping("/api/ingressos")
public class IngressoController {

    @Autowired
    private IngressoService ingressoService;

    // ENDPOINT PARA LISTAR TODOS OS INGRESSOS
    @GetMapping
    public ResponseEntity<List<Ingresso>> listarIngressos() {
        List<Ingresso> ingressos = ingressoService.listarIngressos();
        return ResponseEntity.ok(ingressos);
    }

    // ENDPOINT PARA BUSCAR INGRESSO POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Ingresso> buscarIngressoPorId(@PathVariable Long id) {
        Optional<Ingresso> ingresso = ingressoService.buscarIngressoPorId(id);
        return ingresso.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // ENDPOINT PARA CADASTRAR UM NOVO INGRESSO
    @PostMapping
    public ResponseEntity<Ingresso> cadastrarIngresso(@RequestBody Ingresso ingresso) {
        Ingresso novoIngresso = ingressoService.salvarIngresso(ingresso);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoIngresso);
    }

    // ENDPOINT PARA DELETAR UM INGRESSO POR ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarIngresso(@PathVariable Long id) {
        ingressoService.deletarIngresso(id);
        return ResponseEntity.noContent().build();
    }

    // ENDPOINT PARA ATUALIZAR UM INGRESSO POR ID
    @PutMapping("/{id}")
    public ResponseEntity<Ingresso> atualizarIngresso(@PathVariable Long id, @RequestBody Ingresso ingressoAtualizado) {
        Ingresso ingressoExistente = ingressoService.atualizarIngresso(id, ingressoAtualizado);
        return ResponseEntity.ok(ingressoExistente);
    }
}
