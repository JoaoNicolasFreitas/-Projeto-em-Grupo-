package com.example.demo.facade;

import com.example.demo.applications.OrganizadorApplication;
import com.example.demo.entities.Organizador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrganizadorFacade {

    private OrganizadorApplication organizadorApplication;

    @Autowired
    public OrganizadorFacade(OrganizadorApplication organizadorApplication) {
        this.organizadorApplication = organizadorApplication;
    }

    public List<Organizador> findAll() {
        return this.organizadorApplication.findAll();
    }

    public Organizador findById(int id) {
        return this.organizadorApplication.findById(id);
    }

    public Organizador save(Organizador organizador) {
        return this.organizadorApplication.save(organizador);
    }

    public Organizador update(int id, Organizador organizador) {
        return this.organizadorApplication.update(id, organizador);
    }


    public void deleteById(int id) {
        this.organizadorApplication.deleteById(id);
    }
}