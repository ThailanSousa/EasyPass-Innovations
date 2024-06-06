package com.br.lymtt.easypass.controller;

import com.br.lymtt.easypass.entity.Client;
import com.br.lymtt.easypass.repository.ClientRepository;
import com.br.lymtt.easypass.model.entities.Cliente;
import com.br.lymtt.easypass.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClientRepository clientRepository;

    // Endpoints padrão para Cliente

    // CADASTRAR
    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.cadastrar(cliente);
        return ResponseEntity.ok(novoCliente);
    }

    // LISTAR
    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> clientes = clienteService.listar();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarPorId(@PathVariable Long id) {
        return clienteService.listarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteAtualizado = clienteService.atualizar(id, cliente);
        if (clienteAtualizado != null) {
            return ResponseEntity.ok(clienteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (clienteService.deletar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoints legacy para Client

    @GetMapping("/legacy")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/legacy/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable String id) {
        return clientRepository.findById(id)
                .map(client -> ResponseEntity.ok().body(client))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/legacy")
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PutMapping("/legacy/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable String id, @RequestBody Client clientDetails) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setNome(clientDetails.getNome());
                    client.setIdade(clientDetails.getIdade());
                    client.setEmail(clientDetails.getEmail());
                    client.setCodigoCliente(clientDetails.getCodigoCliente());
                    Client updatedClient = clientRepository.save(client);
                    return ResponseEntity.ok().body(updatedClient);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/legacy/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable String id) {
        return clientRepository.findById(id)
                .map(client -> {
                    clientRepository.delete(client);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
