package com.example.demo.repositories;

import com.example.demo.entities.Organizador;
import com.example.demo.interfaces.IOrganizadorInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganizadorRepository implements IOrganizadorInterface {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Organizador> findAll() {
        String jpql = "SELECT e FROM Organizador e";

        TypedQuery<Organizador> query = entityManager.createQuery(jpql, Organizador.class);

        return query.getResultList();
    }

    @Override
    public Organizador findById(int id) {
        return entityManager.find(Organizador.class, id);
    }

    @Override
    @Transactional
    public Organizador save(Organizador organizador) {
        entityManager.persist(organizador);

        return organizador;
    }

    @Override
    @Transactional
    public Organizador update(int id, Organizador organizador) {
        Organizador organizadorInDb = entityManager.find(Organizador.class, id);

        organizadorInDb.setId(organizador.getId());

        return entityManager.merge(organizadorInDb);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Organizador organizadorInDb = entityManager.find(Organizador.class, id);

        if (organizadorInDb != null) {
            entityManager.remove(organizadorInDb);
        }
    }
}
