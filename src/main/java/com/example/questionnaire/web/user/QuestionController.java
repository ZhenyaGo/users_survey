package com.example.questionnaire.web.user;



import com.example.questionnaire.model.Question;
import com.example.questionnaire.repository.QuestionRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = QuestionController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionController {

    static final String REST_URL = "/api/questions";

    QuestionRepository repository;

    public QuestionController(QuestionRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/surveys/{surveyId}")
    public List<Question> getAll(@PathVariable int surveyId) {
        return repository.getAllBySurveyId(surveyId);
    }

}
