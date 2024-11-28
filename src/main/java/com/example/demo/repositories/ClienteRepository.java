package com.example.demo.repositories;

import com.example.demo.entities.Cliente;
import com.example.demo.interfaces.IClienteInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository implements IClienteInterface {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cliente> findAll() {
        String jpql = "SELECT e FROM Cliente e";

        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);

        return query.getResultList();
    }

    @Override
    public Cliente findById(int id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        entityManager.persist(cliente);

        return cliente;
    }

    @Override
    @Transactional
    public Cliente update(int id, Cliente cliente) {
        Cliente clienteInDb = entityManager.find(Cliente.class, id);

        clienteInDb.setNome(cliente.getNome());
        clienteInDb.setEmail(cliente.getEmail());


        return entityManager.merge(clienteInDb);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Cliente clienteInDb = entityManager.find(Cliente.class, id);

        if (clienteInDb != null) {
            entityManager.remove(clienteInDb);
        }
    }
}