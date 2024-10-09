package com.example.demo.intefaces;

import com.example.demo.entities.Evento;

import java.util.List;

public interface IEventoInterface {

    List<Evento> findAll();

    Evento findById(int id);

    Evento save(Evento Evento);

    public Evento update(int id, Evento base);

    public void deleteById(int id);
}
