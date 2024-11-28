package com.example.demo.applications;

import com.example.demo.entities.Endereco;
import com.example.demo.interfaces.IEnderecoInterface;
import com.example.demo.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnderecoApplication {

    private final IEnderecoInterface enderecoRepository;

    @Autowired
    public EnderecoApplication(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = (IEnderecoInterface) enderecoRepository;
    }

    public List<Endereco> findAll() {
        return this.enderecoRepository.findAll();
    }

    public Endereco findById(int id){ return this.enderecoRepository.findById(id); }

    public Endereco save(Endereco endereco){ return this.enderecoRepository.save(endereco);}

    public Endereco update(int id, Endereco endereco) {
        Endereco enderecoInDb = enderecoRepository.findById(id);

        if (enderecoInDb == null) return null;

        return this.enderecoRepository.update(id, endereco);
    }
    public void deleteById(int id) { this.enderecoRepository.deleteById(id);}

}