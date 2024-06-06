package com.br.lymtt.easypass.model.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lymtt.easypass.model.entities.Promotor;
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
}
