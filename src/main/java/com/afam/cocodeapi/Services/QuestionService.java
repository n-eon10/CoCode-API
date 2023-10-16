package com.afam.cocodeapi.Services;

import com.afam.cocodeapi.Models.QuestionModel;
import com.afam.cocodeapi.Repositories.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<QuestionModel> getAllQuestions() {
        return questionRepository.findAll();
    }

    public QuestionModel getOneQuestion(Long questionId) {
        Optional<QuestionModel> questionModelOptional = questionRepository.findById(questionId);

        if (questionModelOptional.isEmpty()) {
            throw new EntityNotFoundException("The question with id: " + questionId + " cannot be found");
        }

        return questionModelOptional.get();
    }
}
