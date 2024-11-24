package com.example.demo.facade;

import com.example.demo.applications.EventoApplication;
import com.example.demo.entities.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventoFacade {

    private EventoApplication eventoApplication;

    @Autowired
    public void EventoFacede(EventoApplication eventoApplication) {
        this.eventoApplication = eventoApplication;
    }

    public List<Evento> findAll() {
        return this.eventoApplication.findAll();
    }

    public Evento findById(int id) {
        return this.eventoApplication.findById(id);
    }

    public Evento save(Evento evento) {
        return this.eventoApplication.save(evento);
    }

    public Evento update(int id, Evento evento) {
        return this.eventoApplication.update(id, evento);
    }

    public void deleteById(int id) {
        this.eventoApplication.deleteById(id);
    }
}
