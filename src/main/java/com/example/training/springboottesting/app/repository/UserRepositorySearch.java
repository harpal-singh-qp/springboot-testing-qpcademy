package com.example.training.springboottesting.app.repository;

import com.example.training.springboottesting.app.dto.UserRankDto;
import com.example.training.springboottesting.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepositorySearch {

    List<UserRankDto> findYoungest();
}