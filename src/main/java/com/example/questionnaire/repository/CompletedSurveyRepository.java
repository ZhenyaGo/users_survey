package com.example.questionnaire.repository;

import com.example.questionnaire.model.CompletedSurvey;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CompletedSurveyRepository extends BaseRepository<CompletedSurvey> {

}
