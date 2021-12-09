package com.example.training.springboottesting.app.repository;

import com.example.training.springboottesting.app.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;


@org.springframework.stereotype.Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

}