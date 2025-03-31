package com.sp.assess.repository;

import com.sp.assess.entity.CandidateQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CandidateQuizRepository extends JpaRepository<CandidateQuiz, Long> {
    List<CandidateQuiz> findByCandidateId(Long candidateId);
}
