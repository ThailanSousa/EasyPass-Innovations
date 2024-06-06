package com.br.lymtt.easypass.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lymtt.easypass.model.entities.Cliente;
import com.br.lymtt.easypass.model.exception.ResourceNotFoundException;
import com.br.lymtt.easypass.model.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // LISTAR CLIENTES
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // BUSCAR CLIENTE POR ID
    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    // CADASTRAR CLIENTE
    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // DELETAR CLIENTE
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    // Atualizar Cliente
    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente clienteExistente = optionalCliente.get();
            clienteExistente.setNome(clienteAtualizado.getNome());
            clienteExistente.setCpf(clienteAtualizado.getCpf());
            clienteExistente.setGenero(clienteAtualizado.getGenero());
            clienteExistente.setIdade(clienteAtualizado.getIdade());
            clienteExistente.setEmail(clienteAtualizado.getEmail());
            clienteExistente.setNumeroTelefone(clienteAtualizado.getNumeroTelefone());
            return clienteRepository.save(clienteExistente);
        } else {
            throw new ResourceNotFoundException("Cliente com ID " + id + " não encontrado.");
        }
    }

}
