package com.example.training.springboottesting.app.repository;

import com.example.training.springboottesting.app.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;


@org.springframework.stereotype.Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}




