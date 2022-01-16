package com.example.questionnaire.repository;

import com.example.questionnaire.model.Survey;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface SurveyRepository extends BaseRepository<Survey> {
}
