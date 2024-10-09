package com.example.demo.interfaces;

import com.example.demo.entities.Endereco;
import com.example.demo.entities.Localizacao;

import java.util.List;

public interface IEnderecoInterface {

    List<Endereco> findAll();

    Endereco findById(int id);

    Endereco save(Endereco endereco);

    public Endereco update(int id, Localizacao base);

    public void deleteById(int id);
}
