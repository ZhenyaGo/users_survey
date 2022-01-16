package com.example.questionnaire.model;


import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "answers")
public class Answer extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "answer")
    @Size(max = 100)
    private String answer;

    @ManyToOne
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Answer() {

    }

    public Answer(Question question, String answer, Survey survey, User user) {
        this.question = question;
        this.answer = answer;
        this.survey = survey;
        this.user = user;
    }

    public Answer(Integer id, Question question, String answer, Survey survey, User user) {
        super(id);
        this.question = question;
        this.answer = answer;
        this.survey = survey;
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "question=" + question +
                ", answer='" + answer + '\'' +
                ", survey=" + survey +
                ", user=" + user +
                ", id=" + id +
                '}';
    }
}
