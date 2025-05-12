package com.example.votingapp.voting_app.Repository;

import com.example.votingapp.voting_app.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Extending JpaRepo for boilerplate code as well (can straightaway use CRUD)
// <T, ID> T is the entity type & ID is the tpe of the entity primary key
@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
    // for the req payload
    // the key must match exactly how we defined for the entities attributes
    // unless we specify it with @JsonProperty("{val}")
}
