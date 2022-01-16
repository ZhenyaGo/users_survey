package com.example.questionnaire.web;

import com.example.questionnaire.dto.CompletedSurveyTo;
import com.example.questionnaire.model.*;
import com.example.questionnaire.repository.*;
import com.example.questionnaire.util.SurveyUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = SurveyController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class SurveyController {

    static final String REST_URL = "/api/surveys";


    SurveyRepository repository;
    UserRepository userRepository;
    QuestionRepository questionRepository;
    OptionRepository optionRepository;
    CompletedSurveyRepository completedSurveyRepository;

    public SurveyController(SurveyRepository repository, UserRepository userRepository, QuestionRepository questionRepository, OptionRepository optionRepository, CompletedSurveyRepository completedSurveyRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
        this.completedSurveyRepository = completedSurveyRepository;
    }

    @GetMapping
    public List<Survey> getAll() {
        return repository.findAll();
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody CompletedSurveyTo completedSurveysTo) {

        User user = userRepository.getById(completedSurveysTo.getUserId());
        Survey survey = repository.getById(completedSurveysTo.getSurveyId());
        Question question = questionRepository.getById(completedSurveysTo.getQuestionId());
        Option option = optionRepository.getById(completedSurveysTo.getOptionId());
        String text = completedSurveysTo.getText();
        CompletedSurvey completedSurvey = new CompletedSurvey(user, survey, question, text);

        completedSurveyRepository.save(completedSurvey);
    }



}
