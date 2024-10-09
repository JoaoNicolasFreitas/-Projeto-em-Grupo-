package com.example.demo.interfaces;

import com.example.demo.entities.FeedBacks;

import java.util.List;

public interface IFeedBacksInterface {
    List<FeedBacks> findAll();

    FeedBacks findById(int id);

    FeedBacks save(FeedBacks feedBacks);

    FeedBacks update(int id, FeedBacks base);

    void deleteById(int id);
}