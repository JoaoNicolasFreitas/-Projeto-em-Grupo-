package com.example.demo.interfaces;

import com.example.demo.entities.Cliente;

import java.util.List;

public interface IClienteInterface {
    List<Cliente> findAll();

    Cliente findById(int id);

    Cliente save(Cliente cliente);

    public Cliente update(int id, Cliente base);

    public void deleteById(int id);
}
