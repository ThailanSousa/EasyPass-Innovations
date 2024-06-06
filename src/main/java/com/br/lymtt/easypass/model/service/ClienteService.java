package com.br.lymtt.easypass.model.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lymtt.easypass.model.entities.Cliente;
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
}
