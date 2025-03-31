package com.sp.assess.service;

import com.sp.assess.entity.Candidate;
import com.sp.assess.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public Candidate registerCandidate(String name, String email) {
        Candidate candidate = new Candidate(name, email);
        return candidateRepository.save(candidate);
    }
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

}
