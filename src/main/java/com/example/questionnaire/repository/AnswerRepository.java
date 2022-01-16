package com.example.questionnaire.repository;


import com.example.questionnaire.model.Answer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface AnswerRepository extends BaseRepository<Answer> {

    List<Answer> getAllByUserIdAndSurveyId(Integer userId, Integer surveyId);
}
