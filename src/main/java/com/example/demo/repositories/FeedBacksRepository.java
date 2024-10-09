package com.example.demo.repositories;

import com.example.demo.entities.FeedBacks;
import com.example.demo.interfaces.IFeedBacksInterface;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class FeedBacksRepository implements IFeedBacksInterface {

    @Override
    public List<FeedBacks> findAll() {
        return List.of();
    }

    @Override
    public FeedBacks findById(int id) {
        return null;
    }

    @Override
    public FeedBacks save(FeedBacks feedBacks) {
        return null;
    }

    @Override
    public FeedBacks update(int id, FeedBacks feedBacks) {
        return null;
    }

    @Override
    public void deleteById(int id) {
    }
}