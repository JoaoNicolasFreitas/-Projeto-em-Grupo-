package com.example.demo.repositories;

import com.example.demo.entities.Organizador;
import com.example.demo.intefaces.IOrganizadorInterface;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrganizadorRepository implements IOrganizadorInterface {
    @Override
    public List<Organizador> findAll() {
        return List.of();
    }

    @Override
    public Organizador findById(int id) {
        return null;
    }

    @Override
    public Organizador save(Organizador organizador) {
        return null;
    }

    @Override
    public Organizador update(int id, Organizador base) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
