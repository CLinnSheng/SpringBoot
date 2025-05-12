package com.example.votingapp.voting_app.services;

import com.example.votingapp.voting_app.Repository.PollRepository;
import com.example.votingapp.voting_app.model.OptionVote;
import com.example.votingapp.voting_app.model.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {

    private final PollRepository pollRepository;

    @Autowired // Constructor
    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls() {
       return pollRepository.findAll();
    }

    public Optional<Poll> getPollById(Long id) {
        return pollRepository.findById(id);
    }

    public void vote(Long pollId, int optionIndex) {
        // Get poll from DB
        Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new RuntimeException("Poll Not Found"));

        // Get all options
        List<OptionVote> options = poll.getOptions();

        // if index is not valid, throw error
        if (optionIndex < 0 || optionIndex >= options.size())
        {
            throw new IllegalArgumentException("Invalid Option Index");
        }

        // get selected option
        OptionVote selectedOption = options.get(optionIndex);

        // Increment the vote
        selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);

        // increase the vote count --> save into db
        pollRepository.save(poll);
    }
}
