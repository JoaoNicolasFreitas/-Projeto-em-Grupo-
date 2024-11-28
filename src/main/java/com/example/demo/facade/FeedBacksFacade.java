package com.example.demo.facade;

import com.example.demo.applications.FeedBacksApplication;
import com.example.demo.entities.FeedBacks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeedBacksFacade {

    private FeedBacksApplication feedBacksApplication;

    @Autowired
    public FeedBacksFacade(FeedBacksApplication feedBacksApplication) {
        this.feedBacksApplication = feedBacksApplication;
    }

    public List<FeedBacks> findAll() {
        return this.feedBacksApplication.findAll();
    }

    public FeedBacks findById(int id) {
        return this.feedBacksApplication.findById(id);
    }

    public FeedBacks save(FeedBacks feedBacks) {
        return this.feedBacksApplication.save(feedBacks);
    }

    public FeedBacks update(int id, FeedBacks feedBacks) {
        return this.feedBacksApplication.update(id, feedBacks);
    }

    public void deleteById(int id) {
        this.feedBacksApplication.deleteById(id);
    }
}