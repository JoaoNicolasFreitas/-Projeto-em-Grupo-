package com.example.demo.repositories;

import com.example.demo.entities.Endereco;
import com.example.demo.entities.Localizacao;
import com.example.demo.interfaces.IEnderecoInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnderecoRepository implements IEnderecoInterface{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Endereco> findAll() {
        String jpql = "SELECT e FROM Endereco e";

        TypedQuery<Endereco> query = entityManager.createQuery(jpql, Endereco.class);

        return query.getResultList();
    }

    @Override
    public Endereco findById(int id) {
        return entityManager.find(Endereco.class, id);
    }

    @Override
    @Transactional
    public Endereco save(Endereco endereco) {
        entityManager.persist(endereco);

        return endereco;
    }

    @Override
    public Endereco update(int id, Localizacao base) {
        return null;
    }

    @Override
    @Transactional
    public Endereco update(int id, Endereco endereco) {
        Endereco enderecoInDb = entityManager.find(Endereco.class, id);

        enderecoInDb.setEndereco(endereco.getEndereco());

        return entityManager.merge(enderecoInDb);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Endereco enderecoInDb = entityManager.find(Endereco.class, id);

        if (enderecoInDb != null) {
            entityManager.remove(enderecoInDb);
        }
    }
}


