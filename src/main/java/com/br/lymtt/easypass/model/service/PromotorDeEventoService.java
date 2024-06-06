package com.br.lymtt.easypass.model.service;

import com.br.lymtt.easypass.model.entities.PromotorDeEvento;
import com.br.lymtt.easypass.model.repository.PromotorDeEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotorDeEventoService {

    @Autowired
    private PromotorDeEventoRepository promotorDeEventoRepository;

    // Cadastrar
    public PromotorDeEvento cadastrar(PromotorDeEvento promotorDeEvento) {
        return promotorDeEventoRepository.save(promotorDeEvento);
    }

    // Listar todos
    public List<PromotorDeEvento> listar() {
        return promotorDeEventoRepository.findAll();
    }

    // Listar por ID
    public Optional<PromotorDeEvento> listarPorId(Long id) {
        return promotorDeEventoRepository.findById(id);
    }

    // Atualizar
    public PromotorDeEvento atualizar(Long id, PromotorDeEvento promotorDeEvento) {
        return promotorDeEventoRepository.findById(id).map(existingPromotor -> {
            existingPromotor.setNome(promotorDeEvento.getNome());
            existingPromotor.setEmail(promotorDeEvento.getEmail());
            existingPromotor.setTelefone(promotorDeEvento.getTelefone());
            return promotorDeEventoRepository.save(existingPromotor);
        }).orElse(null);
    }

    // Deletar
    public boolean deletar(Long id) {
        return promotorDeEventoRepository.findById(id).map(promotor -> {
            promotorDeEventoRepository.delete(promotor);
            return true;
        }).orElse(false);
    }
}