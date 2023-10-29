package com.afam.cocodeapi.Repositories;

import com.afam.cocodeapi.Models.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionModel, Long> {

    @Query("SELECT CASE WHEN COUNT(question) > 0 THEN true ELSE false END FROM QuestionModel question WHERE question.questionName = ?1")
    boolean existsByQuestionName(String questionName);

    @Query("SELECT question FROM QuestionModel question WHERE question.questionName = ?1")
    Optional<QuestionModel> findByQuestionName(String questionName);
}
