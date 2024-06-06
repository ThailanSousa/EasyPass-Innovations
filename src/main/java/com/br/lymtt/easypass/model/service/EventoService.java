package com.br.lymtt.easypass.model.service;

import com.br.lymtt.easypass.model.entities.Evento;
import com.br.lymtt.easypass.model.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    //CADASTRA
    public Evento cadastrar(Evento evento) {
        return eventoRepository.save(evento);
    }

    //LISTA
    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> listarPorId(Long id) {
        return eventoRepository.findById(id);
    }

    //ATUALIZA
    public Evento atualizar(Long id, Evento updatedEvento) {
        Optional<Evento> existingEvento = eventoRepository.findById(id);
        if (existingEvento.isPresent()) {
            Evento evento = existingEvento.get();
            evento.setData(updatedEvento.getData());
            evento.setLocal(updatedEvento.getLocal());
            evento.setHora(updatedEvento.getHora());
            return eventoRepository.save(evento);
        } else {
            return null; 
        }
    }

    //DELETA
    public boolean deletar(Long id) {
        if (eventoRepository.existsById(id)) {
            eventoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
