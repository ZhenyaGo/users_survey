package com.example.questionnaire.web.admin;


import com.example.questionnaire.model.Question;
import com.example.questionnaire.model.Survey;
import com.example.questionnaire.repository.QuestionRepository;
import com.example.questionnaire.repository.SurveyRepository;
import com.example.questionnaire.util.validation.ValidationUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = AdminQuestionController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminQuestionController {

    static final String REST_URL = "/api/admin/questions";

    QuestionRepository repository;
    SurveyRepository surveyRepository;

    public AdminQuestionController(QuestionRepository repository,SurveyRepository surveyRepository) {
        this.repository = repository;
        this.surveyRepository = surveyRepository;
    }

    @PostMapping(value = "/surveys/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Question> create(@RequestBody Question question, @PathVariable int id) {
        Survey survey = surveyRepository.getById(id);
        question.setSurvey(survey);
        Question newQuestion = repository.save(question);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(newQuestion.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(newQuestion);
    }

    @PutMapping(value = "/{id}/surveys/{surveyId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Question question, @PathVariable int id, @PathVariable int surveyId) {
        ValidationUtil.assureIdConsistent(question, id);
        Survey survey = surveyRepository.getById(surveyId);
        question.setSurvey(survey);
        repository.save(question);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        repository.deleteExisted(id);
    }
}
