package com.example.votingapp.voting_app.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Embeddable // Define a class whose fields are merged into the parent's entity
public class OptionVote {
    private String option;
    private Long voteCount = 0L;
}
