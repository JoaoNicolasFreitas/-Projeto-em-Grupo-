package com.example.demo.controllers;

import com.example.demo.entities.Organizador;
import com.example.demo.facade.OrganizadorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizadores")
public class OrganizadorController {

    private OrganizadorFacade organizadorFacade;

    @Autowired
    public void PagamentoController(OrganizadorFacade organizadorFacade) {
        this.organizadorFacade = organizadorFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Organizador>> findAll() {
        List<Organizador> organizador = this.organizadorFacade.findAll();

        return new ResponseEntity<>(organizador, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Organizador> findById(@PathVariable int id) {
        Organizador organizador = this.organizadorFacade.findById(id);

        if (organizador == null)
            return new ResponseEntity<Organizador>(organizador, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Organizador>(organizador, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Organizador> save(@RequestBody Organizador organizador) {
        Organizador organizadorSaved = organizadorFacade.save(organizador);

        return new ResponseEntity<Organizador>(organizadorSaved, HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Organizador> update(
            @PathVariable int id,
            @RequestBody Organizador organizador) {

        Organizador OrganizadorUpdated = organizadorFacade.update(id, organizador);

        Organizador organizadorUpdated;
        if (organizadorUpdated == null)
            return new ResponseEntity<Organizador>(organizadorUpdated, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Organizador>(organizadorUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        organizadorFacade.deleteById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
