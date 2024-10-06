package com.example.demo.applications;

import java.util.List;

import com.example.demo.entities.Cliente;
import com.example.demo.intefaces.IClienteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClienteApplication {

    private final IClienteInterface clienteRepository;

    @Autowired
    public ClienteApplication(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;

    }

    public List<Cliente> findAll() {
        return this.clienteRepository.findAll();
    }

    public Cliente findById(int id){ return this.clienteRepository.findById(id); }

    public Cliente save(Cliente cliente){ return this.clienteRepository.save(pagamento);}

    public Cliente update(int id, Cliente cliente) {
        Cliente clienteInDb = clienteRepository.findById(id);

        if (clienteInDb == null) return null;

        return this.clienteRepository.update(id, cliente);
    }
    public void deleteById(int id) { this.clienteRepository.deleteById(id);}


}

