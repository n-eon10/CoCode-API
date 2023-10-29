package com.afam.cocodeapi.Controllers;

import com.afam.cocodeapi.Models.QuestionModel;
import com.afam.cocodeapi.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<?> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping(path = "/getone/{questionId}")
    public ResponseEntity<?> getOneQuestion(@PathVariable Long questionId) {
        return questionService.getOneQuestion(questionId);
    }

    @PostMapping(path = "/createquestion")
    public ResponseEntity<?> createQuestion(@RequestBody QuestionModel question) {
        return questionService.createQuestion(question);
    }
}
