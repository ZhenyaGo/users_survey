package com.example.questionnaire.repository;


import com.example.questionnaire.model.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UserRepository extends BaseRepository<User>{
}
