package com.example.demo.services;

import com.example.demo.entities.Cliente;
import com.example.demo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    // Salva um cliente
    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Busca um cliente por ID
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    // Busca todos os clientes
    public List<Cliente> buscarTodosClientes() {
        return clienteRepository.findAll();
    }

    // Deleta um cliente pelo ID
    public boolean deletarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;  // Retorna falso se o cliente não for encontrado
        }
    }

    // Atualiza um cliente
    public Optional<Cliente> atualizarCliente(Long id, Cliente clienteAtualizado) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setTelefone(clienteAtualizado.getTelefone());
            cliente.setEmail(clienteAtualizado.getEmail());
            cliente.setEndereco(clienteAtualizado.getEndereco());
            cliente.setFeedback(clienteAtualizado.getFeedback());
            return Optional.of(clienteRepository.save(cliente));
        } else {
            return Optional.empty();  // Retorna vazio se o cliente não for encontrado
        }
    }
}
