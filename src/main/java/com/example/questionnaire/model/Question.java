package com.example.questionnaire.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "questions")
public class Question extends BaseEntity {

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(max = 100)
    private String name;


    @Column(name = "text", nullable = false)
    @NotBlank
    @Size(max = 300)
    private String text;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "type")
    @Column(name = "type")
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Type> types;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id", nullable = false)
    @JsonBackReference
    private Survey survey;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference
    private List<Option> options;

    public Question() {

    }

    public Question(Question q) {
        this(q.id, q.name, q.text, q.types);
    }

    public Question(Integer id, String name, String text, Collection<Type> types) {
        super(id);
        this.name = name;
        this.text = text;
        setTypes(types);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Type> getTypes() {
        return types;
    }

    public void setTypes(Collection<Type> types) {
        this.types = CollectionUtils.isEmpty(types) ? EnumSet.noneOf(Type.class) : EnumSet.copyOf(types);
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
