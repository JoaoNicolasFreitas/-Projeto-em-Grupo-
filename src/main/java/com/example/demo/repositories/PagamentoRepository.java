package com.example.demo.repositories;

import com.example.demo.entities.Cliente;
import com.example.demo.entities.Evento;
import com.example.demo.entities.Pagamento;
import com.example.demo.interfaces.IPagamentoInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PagamentoRepository implements IPagamentoInterface {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Pagamento> findAll() {
        String jpql = "SELECT e FROM Pagamento e";

        TypedQuery<Pagamento> query = entityManager.createQuery(jpql, Pagamento.class);

        return query.getResultList();
    }

    @Override
    public Pagamento findById(int id) {
        return entityManager.find(Pagamento.class, id);
    }

    @Override
    @Transactional
    public Pagamento save(Pagamento pagamento) {
        Cliente cliente = entityManager.find(Cliente.class, pagamento.getCliente().getId());
        Evento evento = entityManager.find(Evento.class, pagamento.getEvento().getId());

        pagamento.setCliente(cliente);
        pagamento.setEvento(evento);

        entityManager.persist(pagamento);

        return pagamento;
    }

    @Override
    @Transactional
    public Pagamento update(int id, Pagamento pagamento) {
        Pagamento pagamentoInDb = entityManager.find(Pagamento.class, id);

        pagamentoInDb.setId(pagamento.getId());

        return entityManager.merge(pagamentoInDb);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Pagamento pagamentoInDb = entityManager.find(Pagamento.class, id);

        if (pagamentoInDb != null) {
            entityManager.remove(pagamentoInDb);
        }
    }
}
