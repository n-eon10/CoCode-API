package com.afam.cocodeapi.Repositories;

import com.afam.cocodeapi.Models.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionModel, Long> {
}
