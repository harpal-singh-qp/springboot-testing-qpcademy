package com.example.training.springboottesting.app.repository;

import com.example.training.springboottesting.app.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;


@org.springframework.stereotype.Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>{

}