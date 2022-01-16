package com.example.questionnaire.web.user;

import com.example.questionnaire.model.*;
import com.example.questionnaire.repository.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = SurveyController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class SurveyController {

    static final String REST_URL = "/api/surveys";


    SurveyRepository repository;

    public SurveyController(SurveyRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Survey> getAll() {
        return repository.findAll();
    }


}
