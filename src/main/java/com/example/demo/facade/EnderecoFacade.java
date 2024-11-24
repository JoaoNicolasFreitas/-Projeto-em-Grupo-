package com.example.demo.facade;

import com.example.demo.applications.EnderecoApplication;
import com.example.demo.entities.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnderecoFacade {

    private EnderecoApplication enderecoApplication;

    @Autowired
    public EnderecoFacade(EnderecoApplication enderecoApplication) {
        this.enderecoApplication = enderecoApplication;
    }

    public List<Endereco> findAll() {
        return this.enderecoApplication.findAll();
    }

    public Endereco findById(int id) {
        return this.enderecoApplication.findById(id);
    }

    public Endereco save(Endereco endereco) {
        return this.enderecoApplication.save(endereco);
    }

    public Endereco update(int id, Endereco endereco) {
        return this.enderecoApplication.update(id, endereco);
    }

    public void deleteById(int id) {
        this.enderecoApplication.deleteById(id);
    }
}


