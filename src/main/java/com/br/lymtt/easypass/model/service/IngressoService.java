package com.br.lymtt.easypass.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lymtt.easypass.model.entities.Ingresso;
import com.br.lymtt.easypass.model.exception.ResourceNotFoundException;
import com.br.lymtt.easypass.model.repository.IngressoRepository;

@Service
public class IngressoService {

    @Autowired
    private IngressoRepository ingressoRepository;

    public List<Ingresso> listarIngressos() {
        return ingressoRepository.findAll();
    }

    public Optional<Ingresso> buscarIngressoPorId(Long id) {
        return ingressoRepository.findById(id);
    }

    public Ingresso salvarIngresso(Ingresso ingresso) {
        return ingressoRepository.save(ingresso);
    }

    public void deletarIngresso(Long id) {
        ingressoRepository.deleteById(id);
    }

    public Ingresso atualizarIngresso(Long id, Ingresso ingressoAtualizado) {
        Optional<Ingresso> optionalIngresso = ingressoRepository.findById(id);

        if (optionalIngresso.isPresent()) {
            Ingresso ingressoExistente = optionalIngresso.get();
            ingressoExistente.setCliente(ingressoAtualizado.getCliente());
            ingressoExistente.setEvento(ingressoAtualizado.getEvento());
            ingressoExistente.setQuantidade(ingressoAtualizado.getQuantidade());
            ingressoExistente.setDataHoraCompra(ingressoAtualizado.getDataHoraCompra());
            return ingressoRepository.save(ingressoExistente);
        } else {
            throw new ResourceNotFoundException("Ingresso com ID " + id + " não encontrado.");
        }
    }

}
