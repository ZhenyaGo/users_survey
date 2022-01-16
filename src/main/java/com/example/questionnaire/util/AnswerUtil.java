package com.example.questionnaire.util;

import com.example.questionnaire.dto.AnswerTo;
import com.example.questionnaire.model.Answer;

import java.util.List;
import java.util.stream.Collectors;

public class AnswerUtil {


    private AnswerUtil() {
    }

    public static List<AnswerTo> createAnswerTos(List<Answer> completedSurveys) {
        return completedSurveys.stream()
                .map(AnswerUtil::createAnswerTo).collect(Collectors.toList());
    }


    public static AnswerTo createAnswerTo(Answer answer) {
        return new AnswerTo(answer.id(), answer.getUser().id(), answer.getSurvey().id()
                , answer.getQuestion().id(), answer.getAnswer(), answer.getQuestion().getText());
    }


}
