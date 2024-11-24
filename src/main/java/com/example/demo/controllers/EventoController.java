package com.example.demo.controllers;


import com.example.demo.entities.Evento;
import com.example.demo.facade.EventoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {

    private final EventoFacade eventoFacade;

    @Autowired
    public EventoController(EventoFacade eventoFacade) {
        this.eventoFacade = eventoFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Evento>> findAll() {
        List<Evento> evento = this.eventoFacade.findAll();

        return new ResponseEntity<>(evento, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Evento> findById(@PathVariable int id) {
        Evento evento = this.eventoFacade.findById(id);

        if (evento == null)
            return new ResponseEntity<Evento>(evento, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Evento>(evento, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Evento> save(@RequestBody Evento evento) {
        Evento eventoSaved = eventoFacade.save(evento);

        return new ResponseEntity<Evento>(eventoSaved, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Evento> update(
            @PathVariable int id,
            @RequestBody Evento evento) {

        Evento eventoUpdated = eventoFacade.update(id, evento);

        if (eventoUpdated == null)
            return new ResponseEntity<Evento>(eventoUpdated, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Evento>(eventoUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        eventoFacade.deleteById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
