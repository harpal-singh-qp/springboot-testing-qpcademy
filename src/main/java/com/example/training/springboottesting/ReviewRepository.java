package com.example.training.springboottesting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("select r from Review r where upper(r.title) = upper(?1) order by r.content")
    Optional<Review> findByTitleIgnoreCaseOrderByContentAsc(String title);
}