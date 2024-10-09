package com.example.demo.applications;

import com.example.demo.entities.Cliente;
import com.example.demo.entities.Endereco;
import com.example.demo.entities.Localizacao;
import com.example.demo.interfaces.IClienteInterface;
import com.example.demo.interfaces.IEnderecoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoApplication {

    private final IEnderecoInterface enderecoRepository;

    @Autowired
    public EnderecoApplication(EnderecoApplication enderecoApplication, IEnderecoInterface enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco findById(int id) {
        return this.enderecoRepository.findById(id);
    }

    public Endereco save(Endereco endereco) {
        return this.enderecoRepository.save(endereco);
    }

    public Endereco update(int id, Localizacao endereco) {
        Endereco enderecoInDb = enderecoRepository.findById(id);

        if (enderecoInDb == null) return null;

        return this.enderecoRepository.update(id, endereco);
    }

    public void deleteById(int id) {
        this.enderecoRepository.deleteById(id);
    }

}
