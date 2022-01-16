package com.example.questionnaire.web.user;


import com.example.questionnaire.dto.AnswerTo;
import com.example.questionnaire.model.Answer;
import com.example.questionnaire.model.Question;
import com.example.questionnaire.model.Survey;
import com.example.questionnaire.model.User;
import com.example.questionnaire.repository.AnswerRepository;
import com.example.questionnaire.repository.QuestionRepository;
import com.example.questionnaire.repository.SurveyRepository;
import com.example.questionnaire.repository.UserRepository;
import com.example.questionnaire.util.AnswerUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static com.example.questionnaire.web.SecurityUtil.authId;
import static com.example.questionnaire.util.AnswerUtil.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = AnswerController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AnswerController {

    static final String REST_URL = "/api/answers";

    AnswerRepository repository;
    UserRepository userRepository;
    SurveyRepository surveyRepository;
    QuestionRepository questionRepository;


    public AnswerController(AnswerRepository repository, UserRepository userRepository, SurveyRepository surveyRepository, QuestionRepository questionRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.surveyRepository = surveyRepository;
        this.questionRepository = questionRepository;
    }

    @Transactional
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AnswerTo> createAnswer(@RequestBody AnswerTo answerTo) {

        User user = userRepository.getById(authId());
        Survey survey = surveyRepository.getById(answerTo.getSurvey_id());
        Question question = questionRepository.getById(answerTo.getQuestion_id());
        String answer = answerTo.getAnswer();

       Answer newAnswer = new Answer(question, answer, survey, user);

       AnswerTo result = AnswerUtil.createAnswerTo(repository.save(newAnswer));

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(result);

    }


    @GetMapping(value = "/surveys/{id}")
    public List<AnswerTo> getUserAnswers(@PathVariable int id) {
        List<Answer> userAnswers = repository.getAllByUserIdAndSurveyId(authId(), id);
        return createAnswerTos(userAnswers);
    }

    @GetMapping(value = "/surveys/{id}/users/{userId}")
    public List<AnswerTo> getAnswers(@PathVariable int id, @PathVariable int userId) {
        List<Answer> userAnswers = repository.getAllByUserIdAndSurveyId(userId, id);
        return createAnswerTos(userAnswers);
    }

}
