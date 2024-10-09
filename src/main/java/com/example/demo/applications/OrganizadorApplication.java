package com.example.demo.applications;

import com.example.demo.entities.Organizador;
import com.example.demo.intefaces.IOrganizadorInterface;
import com.example.demo.repositories.OrganizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrganizadorApplication {

    private final IOrganizadorInterface organizadorRepository;


    @Autowired
    public OrganizadorApplication(OrganizadorRepository organizadorRepository, IOrganizadorInterface organizadorRepository1) {
        this.organizadorRepository = organizadorRepository1;
    }

    public List<Organizador> findAll() {
        return this.organizadorRepository.findAll();
    }

    public Organizador findById(int id){ return this.organizadorRepository.findById(id); }

    public Organizador save(Organizador organizador){ return this.organizadorRepository.save(organizador);}

    public Organizador update(int id, Organizador organizador) {
        Organizador organzadorInDb = organizadorRepository.findById(id);

        if (organzadorInDb == null) return null;

        return this.organizadorRepository.update(id, organizador);
    }
    public void deleteById(int id) { this.organizadorRepository.deleteById(id);}


}

