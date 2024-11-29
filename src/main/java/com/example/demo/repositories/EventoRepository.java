package com.example.demo.repositories;

import com.example.demo.entities.Evento;
import com.example.demo.interfaces.IEventoInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventoRepository implements IEventoInterface{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Evento> findAll() {
        String jpql = "SELECT e FROM Evento e";

        TypedQuery<Evento> query = entityManager.createQuery(jpql, Evento.class);

        return query.getResultList();
    }

    @Override
    public Evento findById(int id) {
        return entityManager.find(Evento.class, id);
    }

    @Override
    @Transactional
    public Evento save(Evento evento) {
        entityManager.persist(evento);

        return evento;
    }

    @Override
    @Transactional
    public Evento update(int id, Evento evento) {
        Evento eventoInDb = entityManager.find(Evento.class, id);

        eventoInDb.setValor(evento.getValor());


        return entityManager.merge(evento);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Evento eventoInDb = entityManager.find(Evento.class, id);

        if (eventoInDb != null) {
            entityManager.remove(eventoInDb);
        }
    }
}

