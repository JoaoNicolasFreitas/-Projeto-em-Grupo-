package com.example.demo.interfaces;

import com.example.demo.entities.Organizador;

import java.util.List;

public interface IOrganizadorInterface {
    List<Organizador> findAll();

    Organizador findById(int id);

    Organizador save(Organizador organizador);

    public Organizador update(int id, Organizador base);

    public void deleteById(int id);
}