package com.sp.assess.controller;

import com.sp.assess.entity.CandidateQuiz;
import com.sp.assess.entity.Question;
import com.sp.assess.entity.Quiz;
import com.sp.assess.service.QuizService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // Create a new quiz
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Quiz createQuiz(@RequestParam String title, @RequestBody List<Long> questionIds) {
        return quizService.createQuiz(title, questionIds);
    }

    // Get all quizzes
    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    // Get quiz by ID
    @GetMapping("/{id}")
    public Optional<Quiz> getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id);
    }

    // Get random questions
    @GetMapping("/random")
    public List<Question> getRandomQuestions(@RequestParam int count) {
        return quizService.getRandomQuestions(count);
    }

    // Enroll candidate in a quiz
    @PostMapping("/{quizId}/enroll/{candidateId}")
    public CandidateQuiz enrollCandidate(@PathVariable Long quizId, @PathVariable Long candidateId) {
        return quizService.enrollCandidateInQuiz(quizId, candidateId);
    }

    // Get all quizzes assigned to a candidate
    @GetMapping("/candidate/{candidateId}")
    public List<Quiz> getCandidateQuizzes(@PathVariable Long candidateId) {
        return quizService.getQuizzesForCandidate(candidateId);
    }

}
