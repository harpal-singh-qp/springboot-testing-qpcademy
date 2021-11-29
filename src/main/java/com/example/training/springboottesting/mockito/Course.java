package com.example.training.springboottesting.mockito;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "course")
@Entity(name = "Course")
@Getter
@Setter
public class    Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "course_name", length = 100)
    private String courseName;

    @Column(name = "course_duration", length = 100)
    private String courseDuration;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "coach_name", length = 100)
    private String coachName;

    @Column(name = "course_category", length = 100)
    private String courseCategory;


    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "user_id")
    private Long userId;

}