package com.example.questionnaire.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "surveys")
public class Survey extends BaseEntity {

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(max = 100)
    private String name;

    @Column(name = "start_Date", nullable = false)
    @NotNull
    private LocalDate startDate;

    @Column(name = "end_Date", nullable = false)
    @NotNull
    private LocalDate endDate;

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(max = 300)
    private String description;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "survey")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference
    private List<Question> questions;


    public Survey() {

    }

    public Survey(String name, LocalDate startDate, LocalDate endDate, String description) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public Survey(Integer id, String name, LocalDate startDate, LocalDate endDate, String description) {
        super(id);
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

}
