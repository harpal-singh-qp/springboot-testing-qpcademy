package com.example.training.springboottesting.app.repository;

import com.example.training.springboottesting.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.firstName = :firstName")
    List<User> findByName(@Param("firstName") String firstName );

    @Query(value = "SELECT    first_name, age,  @curRank := @curRank + 1 AS rank FROM      user p, (SELECT @curRank := 0) r ORDER BY  age;" ,
            nativeQuery = true)
    List<User> findYoungest();
}