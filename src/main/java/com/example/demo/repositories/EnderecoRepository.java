package com.example.demo.repositories;

import com.example.demo.entities.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnderecoRepository {

    @Override
    public List<Endereco> findAll() {
        return List.of();
    }

    @Override
    public Endereco findById(int id) {
        return null;
    }

    @Override
    public Endereco save(Endereco endereco) {
        return null;
    }

    @Override
    public Endereco update(int id, Endereco base) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

}
