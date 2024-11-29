package com.example.demo.repositories;

import com.example.demo.entities.FeedBacks;
import com.example.demo.interfaces.IFeedBacksInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeedBacksRepository implements IFeedBacksInterface {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<FeedBacks> findAll() {
        String jpql = "SELECT e FROM FeedBacks e";

        TypedQuery<FeedBacks> query = entityManager.createQuery(jpql, FeedBacks.class);

        return query.getResultList();
    }

    @Override
    public FeedBacks findById(int id) {
        return entityManager.find(FeedBacks.class, id);
    }

    @Override
    @Transactional
    public FeedBacks save(FeedBacks feedBacks) {
        entityManager.persist(feedBacks);

        return feedBacks;
    }

    @Override
    @Transactional
    public FeedBacks update(int id, FeedBacks feedBacks) {
        FeedBacks feedBacksInDb = entityManager.find(FeedBacks.class, id);

        feedBacksInDb.setNotaFeedbacks(feedBacks.getNotaFeedbacks());



        return entityManager.merge(feedBacksInDb);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        FeedBacks feedBacksInDb = entityManager.find(FeedBacks.class, id);

        if (feedBacksInDb != null) {
            entityManager.remove(feedBacksInDb);
        }
    }
}