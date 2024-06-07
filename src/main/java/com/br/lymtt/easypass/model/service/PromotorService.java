package com.br.lymtt.easypass.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.lymtt.easypass.model.entities.Promotor;
import com.br.lymtt.easypass.model.exception.ResourceNotFoundException;
import com.br.lymtt.easypass.model.repository.PromotorRepository;

@Service
public class PromotorService {

    @Autowired
    private PromotorRepository promotorRepository;

    // LISTAR PROMOTORES
    public List<Promotor> listarPromotores() {
        return promotorRepository.findAll();
    }

    // BUSCAR PROMOTOR POR ID
    public Optional<Promotor> buscarPromotorPorId(Long id) {
        return promotorRepository.findById(id);
    }

    // CADASTRAR PROMOTOR
    public Promotor salvarPromotor(Promotor promotor) {
        return promotorRepository.save(promotor);
    }

    // DELETAR PROMOTOR
    public void deletarPromotor(Long id) {
        promotorRepository.deleteById(id);
    }

    // Atualizar Promotor
    public Promotor atualizarPromotor(Long id, Promotor promotorAtualizado) {
        Optional<Promotor> optionalPromotor = promotorRepository.findById(id);

        if (optionalPromotor.isPresent()) {
            Promotor promotorExistente = optionalPromotor.get();
            promotorExistente.setNome(promotorAtualizado.getNome());
            promotorExistente.setCpf(promotorAtualizado.getCpf());
            promotorExistente.setGenero(promotorAtualizado.getGenero());
            promotorExistente.setIdade(promotorAtualizado.getIdade());
            promotorExistente.setEmpresa(promotorAtualizado.getEmpresa());
            promotorExistente.setEvento(promotorAtualizado.getEvento());
            return promotorRepository.save(promotorExistente);
        } else {
            throw new ResourceNotFoundException("Promotor com ID " + id + " não encontrado.");
        }
    }
}
