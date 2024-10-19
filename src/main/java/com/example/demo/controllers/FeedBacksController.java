package com.example.demo.controllers;

import com.example.demo.entities.FeedBacks;
import com.example.demo.facade.FeedBacksFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedBacksController {

    private final FeedBacksFacade feedBacksFacade;

    @Autowired
    public FeedBacksController(FeedBacksFacade feedBacksFacade) {
        this.feedBacksFacade = feedBacksFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<FeedBacks>> findAll() {
        List<FeedBacks> feedbacks = this.feedBacksFacade.findAll();
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<FeedBacks> findById(@PathVariable int id) {
        FeedBacks feedBacks = this.feedBacksFacade.findById(id);

        if (feedBacks == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(feedBacks, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<FeedBacks> save(@RequestBody FeedBacks feedBacks) {
        FeedBacks feedBacksSaved = feedBacksFacade.save(feedBacks);
        return new ResponseEntity<>(feedBacksSaved, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FeedBacks> update(@PathVariable int id, @RequestBody FeedBacks feedBacks) {
        FeedBacks feedBacksUpdated = feedBacksFacade.update(id, feedBacks);

        if (feedBacksUpdated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(feedBacksUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        feedBacksFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}