package com.br.lymtt.easypass.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lymtt.easypass.model.entities.Evento;
import com.br.lymtt.easypass.model.exception.ResourceNotFoundException;
import com.br.lymtt.easypass.model.repository.EventoRepository;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    // LISTAR EVENTOS
    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    // BUSCAR EVENTO POR ID
    public Optional<Evento> buscarEventoPorId(Long id) {
        return eventoRepository.findById(id);
    }

    // CADASTRAR EVENTO
    public Evento salvarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    // DELETAR EVENTO
    public void deletarEvento(Long id) {
        eventoRepository.deleteById(id);
    }

    // Atualizar Evento
    public Evento atualizarEvento(Long id, Evento eventoAtualizado) {
        Optional<Evento> optionalEvento = eventoRepository.findById(id);

        if (optionalEvento.isPresent()) {
            Evento eventoExistente = optionalEvento.get();
            eventoExistente.setNomeEvento(eventoAtualizado.getNomeEvento());
            eventoExistente.setData(eventoAtualizado.getData());
            eventoExistente.setLocal(eventoAtualizado.getLocal());
            eventoExistente.setHora(eventoAtualizado.getHora());
            return eventoRepository.save(eventoExistente);
        } else {
            throw new ResourceNotFoundException("Evento com ID " + id + " não encontrado.");
        }
    }

}
