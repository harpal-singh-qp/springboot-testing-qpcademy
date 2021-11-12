package com.example.training.springboottesting;/* harpalsingh created on 11/9/21 inside the package - com.example.training.springboottesting */

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
/**
 * @author Harpal Singh 11/12/21
 */
@Entity(name = "Course")
@Table(name = "course")
@Setter
@Getter
@ToString
public class Course {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="course_name")
    private String courseName;

}