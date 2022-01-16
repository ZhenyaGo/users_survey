package com.example.questionnaire.repository;


import com.example.questionnaire.model.Option;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface OptionRepository extends BaseRepository<Option> {
}
