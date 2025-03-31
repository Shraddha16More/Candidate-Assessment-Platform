package com.sp.assess.service;

import com.sp.assess.entity.CandidateQuiz;
import com.sp.assess.entity.Question;
import com.sp.assess.entity.Quiz;
import com.sp.assess.repository.CandidateQuizRepository;
import com.sp.assess.repository.QuestionRepository;
import com.sp.assess.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private CandidateQuizRepository candidateQuizRepository;

    public Quiz createQuiz(String title, List<Long> questionIds) {
        if (questionIds == null || questionIds.isEmpty()) {
            throw new IllegalArgumentException("A quiz must contain at least one question.");
        }

        // Check if a quiz with the same title already exists
        Optional<Quiz> existingQuiz = quizRepository.findByTitle(title);
        if (existingQuiz.isPresent()) {
            throw new IllegalArgumentException("A quiz with this title already exists.");
        }

        List<Question> questions = questionRepository.findAllById(questionIds);
        Quiz quiz = new Quiz(title, questions);
        return quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }

    public List<Question> getRandomQuestions(int count) {
        List<Question> allQuestions = questionRepository.findAll();
        return new Random()
                .ints(0, allQuestions.size())
                .distinct()
                .limit(count)
                .mapToObj(allQuestions::get)
                .collect(Collectors.toList());
    }

    public CandidateQuiz enrollCandidateInQuiz(Long quizId, Long candidateId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new IllegalArgumentException("Quiz not found"));

        CandidateQuiz candidateQuiz = new CandidateQuiz(quiz, candidateId);
        return candidateQuizRepository.save(candidateQuiz);
    }

    public List<Quiz> getQuizzesForCandidate(Long candidateId) {
        List<CandidateQuiz> candidateQuizzes = candidateQuizRepository.findByCandidateId(candidateId);
        return candidateQuizzes.stream()
                .map(CandidateQuiz::getQuiz)
                .collect(Collectors.toList());
    }

}
