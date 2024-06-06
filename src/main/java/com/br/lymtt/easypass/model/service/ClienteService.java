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

    // CADASTRAR
    public Cliente cadastrar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // LISTAR TODOS
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    // LISTAR POR ID
    public Optional<Cliente> listarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    // ATUALIZAR
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

    // DELETAR
    public boolean deletar(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // LEGACY METHODS

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
