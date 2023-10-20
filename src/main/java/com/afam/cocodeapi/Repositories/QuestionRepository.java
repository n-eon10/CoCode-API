package com.afam.cocodeapi.Repositories;

import com.afam.cocodeapi.Models.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionModel, Long> {
}
