package com.example.votingapp.voting_app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
// Map to a table in the DB
@Data
// For generating boilerplate (eg: setter, getter & etc)
@NoArgsConstructor
// Generating boilerplate code as well (no need to manually write out the constructor with zero args
// All the primitive will be assign the default value & object will be assign null
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // This field is automatically generated when a new row is inserted
    private Long id;
    private String question;

    @ElementCollection
    private List<OptionVote> options = new ArrayList<>();

    // Use for creating another table without creating another separate entity
    // And also fully owned by the parent entity
    // @ElementCollection
//    @ElementCollection
//    private List<Long> votes = new ArrayList<>();

}
