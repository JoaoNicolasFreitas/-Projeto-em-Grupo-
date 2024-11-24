package com.example.demo.applications;

import com.example.demo.entities.Evento;
import com.example.demo.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventoApplication {

    private final EventoRepository eventoRepository;
    private Evento Evento;

    @Autowired
    public EventoApplication(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> findAll() {
        return this.eventoRepository.findAll();
    }

    public Evento findById(int id){ return this.eventoRepository.findById(id); }

    public Evento save(Evento cliente){ return this.eventoRepository.save(cliente);}

    public Evento update(int id, Evento cliente) {
        Evento clienteInDb = eventoRepository.findById(id);

        if (clienteInDb == null) return null;

        return this.eventoRepository.update(id, Evento);
    }
    public void deleteById(int id) { this.eventoRepository.deleteById(id);}

}
