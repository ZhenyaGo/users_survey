package com.example.questionnaire.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "completed_survey")
public class CompletedSurvey extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Survey survey;


    @ManyToOne
    @JoinColumn(name = "question_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "option_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Option option;


    @Column(name = "text")
    private String text;

    public CompletedSurvey() {

    }


    public CompletedSurvey(User user, Survey survey, Question question, String text) {
        super();
        this.user = user;
        this.survey = survey;
        this.question = question;
        this.text = text;
    }

    public CompletedSurvey(Integer id, User user, Survey survey, Question question, String text) {
        super(id);
        this.user = user;
        this.survey = survey;
        this.question = question;
        this.text = text;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
