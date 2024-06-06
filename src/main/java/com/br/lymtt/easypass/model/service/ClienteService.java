package com.br.lymtt.easypass.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lymtt.easypass.model.entities.Cliente;
import com.br.lymtt.easypass.model.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void criarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public void atualizarCliente(Long id, Cliente cliente) throws Exception {
        if (!clienteRepository.existsById(id)) {
            throw new Exception("Cliente não encontrado");
        }
        cliente.setId(id);
        clienteRepository.save(cliente);
    }

    public Cliente buscarCliente(Long id) throws Exception {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new Exception("Cliente não encontrado"));
    }

    public void deletarCliente(Long id) throws Exception {
        if (!clienteRepository.existsById(id)) {
            throw new Exception("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}
