package com.example.questionnaire.util;

import com.example.questionnaire.dto.CompletedSurveyTo;
import com.example.questionnaire.model.CompletedSurvey;

import java.util.List;
import java.util.stream.Collectors;

public class SurveyUtil {


    private SurveyUtil() {
    }

    public static List<CompletedSurveyTo> createCompletedSurveyTos(List<CompletedSurvey> completedSurveys) {
        return completedSurveys.stream()
                .map(SurveyUtil::createCompletedSurveyTo).collect(Collectors.toList());
    }


    public static CompletedSurveyTo createCompletedSurveyTo(CompletedSurvey completedSurvey) {
        return new CompletedSurveyTo(completedSurvey.id(), completedSurvey.getUser().id(), completedSurvey.getSurvey().id()
                , completedSurvey.getQuestion().id(), completedSurvey.getText());
    }





}
