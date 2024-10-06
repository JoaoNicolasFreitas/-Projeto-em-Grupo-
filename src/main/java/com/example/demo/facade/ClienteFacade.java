package com.example.demo.facade;

import com.example.demo.applications.ClienteApplication;
import com.example.demo.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteFacade {

    private ClienteApplication clienteApplication;

    @Autowired
    public ClienteFacade(ClienteApplication clienteApplication) {
        this.clienteApplication = clienteApplication;
    }

    public List<Cliente> findAll() {
        return this.clienteApplication.findAll();
    }

    public Cliente findById(int id) {
        return this.clienteApplication.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return this.clienteApplication.save(cliente);
    }

    public Cliente update(int id, Cliente cliente) {
        return this.clienteApplication.update(id, cliente);
    }


    public void deleteById(int id) {
        this.clienteApplication.deleteById(id);
    }
}