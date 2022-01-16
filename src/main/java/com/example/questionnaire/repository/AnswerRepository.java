package com.example.questionnaire.repository;


import com.example.questionnaire.model.Answer;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface AnswerRepository extends BaseRepository<Answer> {
}
