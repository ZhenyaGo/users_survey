package com.example.questionnaire.repository;

import com.example.questionnaire.model.Question;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public interface QuestionRepository extends BaseRepository<Question> {

}

