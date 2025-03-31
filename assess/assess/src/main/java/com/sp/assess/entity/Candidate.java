package com.sp.assess.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    private LocalDateTime submissionTime;
    private Integer score;

    public Candidate() {}

    public Candidate(String name, String email) {
        this.name = name;
        this.email = email;
        this.submissionTime = null; // Initially, no submission
        this.score = null; // Score will be updated after quiz attempt
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDateTime getSubmissionTime() { return submissionTime; }
    public void setSubmissionTime(LocalDateTime submissionTime) { this.submissionTime = submissionTime; }
    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
}
