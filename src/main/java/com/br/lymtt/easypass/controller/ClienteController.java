package com.br.lymtt.easypass.controller;

import com.br.lymtt.easypass.entity.Client;
import com.br.lymtt.easypass.repository.ClientRepository;
import com.br.lymtt.easypass.model.entities.Cliente;
import com.br.lymtt.easypass.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

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

    @PostMapping
    public ResponseEntity<Void> criarCliente(@RequestBody Cliente cliente) {
        clienteService.criarCliente(cliente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/legacy")
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        try {
            clienteService.atualizarCliente(id, cliente);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id) {
        try {
            Cliente cliente = clienteService.buscarCliente(id);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
