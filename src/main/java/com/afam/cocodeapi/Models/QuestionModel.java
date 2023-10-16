package com.afam.cocodeapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class QuestionModel {
    @Id
    @SequenceGenerator(
            name = "question_sequence",
            sequenceName = "question_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "question_sequence"
    )
    private Long id;
    private String questionName;
    private String question;
    private String questionExamples;
    private String constraints;

    public QuestionModel() {
    }

    public QuestionModel(Long id, String questionName, String question, String questionExamples, String constraints) {
        this.id = id;
        this.questionName = questionName;
        this.question = question;
        this.questionExamples = questionExamples;
        this.constraints = constraints;
    }

    public QuestionModel(String questionName, String question, String questionExamples, String constraints) {
        this.questionName = questionName;
        this.question = question;
        this.questionExamples = questionExamples;
        this.constraints = constraints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestionExamples() {
        return questionExamples;
    }

    public void setQuestionExamples(String questionExamples) {
        this.questionExamples = questionExamples;
    }

    public String getConstraints() {
        return constraints;
    }

    public void setConstraints(String constraints) {
        this.constraints = constraints;
    }

    @Override
    public String toString() {
        return "QuestionModel{" +
                "id=" + id +
                ", questionName='" + questionName + '\'' +
                ", question='" + question + '\'' +
                ", questionExamples='" + questionExamples + '\'' +
                ", constraints='" + constraints + '\'' +
                '}';
    }
}
