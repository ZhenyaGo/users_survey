package com.example.questionnaire.web;

import com.example.questionnaire.model.Option;
import com.example.questionnaire.model.Question;
import com.example.questionnaire.repository.OptionRepository;
import com.example.questionnaire.repository.QuestionRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = AdminOptionsController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminOptionsController {

    static final String REST_URL = "/api/admin/options";


    OptionRepository optionRepository;
    QuestionRepository questionRepository;

    public AdminOptionsController(OptionRepository optionRepository, QuestionRepository questionRepository) {
        this.optionRepository = optionRepository;
        this.questionRepository = questionRepository;
    }

    @PostMapping(value = "/question/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Option> create(@RequestBody List<Option> option, @PathVariable int id) {
        Question question = questionRepository.getById(id);
        for (Option o : option) {
            o.setQuestion(question);
        }
        optionRepository.saveAll(option);
        return optionRepository.saveAll(option);
    }

}
