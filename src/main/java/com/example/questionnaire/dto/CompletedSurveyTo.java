package com.example.questionnaire.dto;



public class CompletedSurveyTo extends BaseTo {

    Integer userId;


    Integer surveyId;

    Integer questionId;

    Integer optionId;

    String text;

    public CompletedSurveyTo() {

    }

    public CompletedSurveyTo(Integer userId, Integer surveyId, Integer questionId, Integer optionId, String text) {
        this.userId = userId;
        this.surveyId = surveyId;
        this.questionId = questionId;
        this.optionId = optionId;
        this.text = text;
    }

    public CompletedSurveyTo(Integer id, Integer userId, Integer surveyId, Integer questionId, Integer optionId, String text) {
        super(id);
        this.userId = userId;
        this.surveyId = surveyId;
        this.questionId = questionId;
        this.optionId = optionId;
        this.text = text;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
