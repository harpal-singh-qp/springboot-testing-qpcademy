package com.example.training.springboottesting;/* harpalsingh created on 11/9/21 inside the package - com.example.training.springboottesting */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author Harpal Singh 11/12/21
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {



}
