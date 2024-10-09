package com.example.demo.repositories;

import com.example.demo.entities.Cliente;
import com.example.demo.intefaces.IClienteInterface;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteRepository implements IClienteInterface {
    @Override
    public List<Cliente> findAll() {
        return List.of();
    }

    @Override
    public Cliente findById(int id) {
        return null;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente update(int id, Cliente base) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
