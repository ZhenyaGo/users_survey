package com.example.questionnaire.dto;


public class AnswerTo extends BaseTo {


    Integer user_id;

    Integer survey_id;

    Integer question_id;

    String answer;

    String questionName;


    public AnswerTo() {

    }

    public AnswerTo(Integer user_id, Integer survey_id, Integer question_id, String answer) {
        this.user_id = user_id;
        this.survey_id = survey_id;
        this.question_id = question_id;
        this.answer = answer;
    }

    public AnswerTo(Integer id, Integer user_id, Integer survey_id, Integer question_id, String answer, String questionName) {
        super(id);
        this.user_id = user_id;
        this.survey_id = survey_id;
        this.question_id = question_id;
        this.answer = answer;
        this.questionName = questionName;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(Integer survey_id) {
        this.survey_id = survey_id;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "AnswerTo{" +
                "user_id=" + user_id +
                ", survey_id=" + survey_id +
                ", question_id=" + question_id +
                ", answer='" + answer + '\'' +
                ", id=" + id +
                '}';
    }
}
