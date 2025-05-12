package com.example.votingapp.voting_app.controller;

import com.example.votingapp.voting_app.model.Poll;
import com.example.votingapp.voting_app.model.Vote;

import com.example.votingapp.voting_app.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
public class PollController {

    // We can also put "Autowired" over here but for best pratice is better to use for constructor for clean code purpose
    private PollService pollService;

    @Autowired
    // Constructor or Setter
    // If only one constructor can be omit, if have multiple need to mentioned which constructor in order for Spring know which constructor to use to inject the dependency
    // However for setter, is compulsory. For instance at here, pollService will still be null if we didnt mentioned the annotation autowired at the setter
    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll) {
        return pollService.createPoll(poll);
    }

    @GetMapping
    public List<Poll> getAllPolls() {
        return pollService.getAllPolls();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPollById(@PathVariable Long id) {
        return pollService.getPollById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/vote")
    public void vote(@RequestBody Vote vote) {
         pollService.vote(vote.getPollId(), vote.getOptionIndex());
    }

}
