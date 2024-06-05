package com.br.lymtt.easypass.model.service;

import com.br.lymtt.easypass.model.entities.Cliente;
import com.br.lymtt.easypass.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //CADASTRANDO
    public Cliente cadastrar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    //LISTANDO
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> listarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    //ATUALIZANDO ESSE MALDITO
    public Cliente atualizar(Long id, Cliente updatedCliente) {
        Optional<Cliente> existingCliente = clienteRepository.findById(id);
        if (existingCliente.isPresent()) {
            Cliente cliente = existingCliente.get();
            cliente.setNome(updatedCliente.getNome());
            cliente.setCpf(updatedCliente.getCpf());
            cliente.setGenero(updatedCliente.getGenero());
            cliente.setIdade(updatedCliente.getIdade());
            cliente.setEmail(updatedCliente.getEmail());
            cliente.setNumeroTelefone(updatedCliente.getNumeroTelefone());
            return clienteRepository.save(cliente);
        } else {
            return null;
        }
    }
    
    //DELETANDO ESSE CACETE
    public boolean deletar(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false; 
        }
    }
}
