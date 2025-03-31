package com.sp.assess.entity;

import jakarta.persistence.*;

@Entity
public class CandidateQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Quiz quiz;

    @Column(nullable = false)
    private Long candidateId; // Store candidate's unique ID

    public CandidateQuiz() {}

    public CandidateQuiz(Quiz quiz, Long candidateId) {
        this.quiz = quiz;
        this.candidateId = candidateId;
    }

    public Long getId() {
        return id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public Long getCandidateId() {
        return candidateId;
    }
}
