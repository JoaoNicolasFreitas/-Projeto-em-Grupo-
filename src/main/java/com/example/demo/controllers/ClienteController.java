package com.example.demo.controllers;

import com.example.demo.entities.Cliente;
import com.example.demo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Endpoint para salvar um cliente
    @PostMapping
    public Cliente salvarCliente(@RequestBody Cliente cliente) {
        return clienteService.salvarCliente(cliente);
    }

    // Endpoint para buscar um cliente pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.buscarPorId(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para listar todos os clientes
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.buscarTodosClientes();
    }

    // Endpoint para deletar um cliente pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        if (clienteService.deletarCliente(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para atualizar um cliente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        Optional<Cliente> cliente = clienteService.atualizarCliente(id, clienteAtualizado);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
