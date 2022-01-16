package com.example.questionnaire.web;


import com.example.questionnaire.model.Survey;
import com.example.questionnaire.repository.SurveyRepository;
import com.example.questionnaire.util.validation.ValidationUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = AdminSurveyController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminSurveyController {

    static final String REST_URL = "/api/admin/surveys";

    SurveyRepository repository;

    public AdminSurveyController(SurveyRepository repository) {
        this.repository = repository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Survey> create(@RequestBody Survey survey) {
        Survey newSurvey = repository.save(survey);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(newSurvey.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(newSurvey);
    }


    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Survey survey, @PathVariable int id) {
        ValidationUtil.assureIdConsistent(survey, id);
        repository.save(survey);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        repository.deleteExisted(id);
    }




}


