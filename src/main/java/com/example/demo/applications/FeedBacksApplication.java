package com.example.demo.applications;

import com.example.demo.entities.FeedBacks;
import com.example.demo.repositories.FeedBacksRepository;
import com.example.demo.interfaces.IFeedBacksInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeedBacksApplication {

    private final IFeedBacksInterface feedBacksRepository;

    @Autowired
    public FeedBacksApplication(FeedBacksRepository feedBacksRepository) {
        this.feedBacksRepository = feedBacksRepository;
    }

    public List<FeedBacks> findAll() {
        return this.feedBacksRepository.findAll();
    }

    public FeedBacks findById(int id) {
        return this.feedBacksRepository.findById(id);
    }

    public FeedBacks save(FeedBacks feedBacks) {
        return this.feedBacksRepository.save(feedBacks);
    }

    public FeedBacks update(int id, FeedBacks feedBacks) {
        FeedBacks feedBacksInDb = feedBacksRepository.findById(id);

        if (feedBacksInDb == null) return null;

        return this.feedBacksRepository.update(id, feedBacks);
    }

    public void deleteById(int id) {
        this.feedBacksRepository.deleteById(id);
    }
}