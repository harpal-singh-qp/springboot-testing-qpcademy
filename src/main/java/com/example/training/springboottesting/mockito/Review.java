package com.example.training.springboottesting.mockito;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "reviews")
@Entity(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "user_id")
    private Long userId;


}