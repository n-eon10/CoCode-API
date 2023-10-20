package com.afam.cocodeapi.Controllers;

import com.afam.cocodeapi.Models.QuestionModel;
import com.afam.cocodeapi.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<QuestionModel> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping(path = "/getone/{questionId}")
    public QuestionModel getOneQuestion(@PathVariable Long questionId) {
        return questionService.getOneQuestion(questionId);
    }

    @PostMapping(path = "/createquestion")
    public QuestionModel createQuestion(QuestionModel question) {
        return questionService.createQuestion(question);
    }
}
