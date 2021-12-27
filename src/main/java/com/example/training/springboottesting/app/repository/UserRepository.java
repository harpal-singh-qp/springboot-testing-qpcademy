package com.example.training.springboottesting.app.repository;

import com.example.training.springboottesting.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> ,UserRepositorySearch {

    @Query("select u from User u where u.firstName = :firstName")
    List<User> findByName(@Param("firstName") String firstName );

    List<User> findByEmailAddress(String emailAddress);
}