package com.example.questionnaire.repository;


import com.example.questionnaire.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface UserRepository extends BaseRepository<User>{

    Optional<User> getByEmail(String email);
}
