package com.sp.assess.controller;

import com.sp.assess.entity.Candidate;
import com.sp.assess.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/register")
    public ResponseEntity<Candidate> registerCandidate(@RequestParam String name, @RequestParam String email) {
        Candidate candidate = candidateService.registerCandidate(name, email);
        return ResponseEntity.ok(candidate);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        List<Candidate> candidates = candidateService.getAllCandidates();
        return ResponseEntity.ok(candidates);
    }

}
