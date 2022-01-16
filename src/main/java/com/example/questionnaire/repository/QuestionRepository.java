package com.example.questionnaire.repository;

import com.example.questionnaire.model.Question;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = true)
public interface QuestionRepository extends BaseRepository<Question> {

    List<Question> getAllBySurveyId(int surveyId);

}

