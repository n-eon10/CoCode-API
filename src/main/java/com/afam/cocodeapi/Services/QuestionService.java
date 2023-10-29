package com.afam.cocodeapi.Services;

import com.afam.cocodeapi.Models.QuestionModel;
import com.afam.cocodeapi.Repositories.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    public ResponseEntity<?> getAllQuestions() {
        List<QuestionModel> questions = questionRepository.findAll();
        return ResponseEntity.ok(questions);
    }

    public ResponseEntity<?> getOneQuestion(Long questionId) {
        Optional<QuestionModel> questionModelOptional = questionRepository.findById(questionId);

        if (questionModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The question you are looking for does not exist");
        }

        QuestionModel question = questionModelOptional.get();
        return ResponseEntity.ok(question);

    }
}