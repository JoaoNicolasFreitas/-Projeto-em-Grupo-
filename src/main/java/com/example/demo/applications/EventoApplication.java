package com.example.demo.applications;

import com.example.demo.entities.Evento;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EventoApplication {

    private final EventoApplication eventoApplications;
    private com.example.demo.entities.Evento Evento;

    @Autowired
    public EventoApplication(EventoApplication eventoApplications) {
        this.eventoApplications = eventoApplications;
    }

    public List<Evento> findAll() {
        return this.eventoApplications.findAll();
    }

    public Evento findById(int id){ return this.eventoApplications.findById(id); }

    public Evento save(Evento cliente){ return this.eventoApplications.save(cliente);}

    public Evento update(int id, Evento cliente) {
        Evento clienteInDb = eventoApplications.findById(id);

        if (clienteInDb == null) return null;

        return this.eventoApplications.update(id, Evento);
    }
    public void deleteById(int id) { this.eventoApplications.deleteById(id);}

}
