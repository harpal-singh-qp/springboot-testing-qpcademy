package com.example.training.springboottesting;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "course_rating")
@Entity(name = "CourseRating")
@Getter
@Setter
@ToString
@Builder
public class CourseRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "rated_by")
    private String ratedBy;

    @Column(name = "rating")
    private Integer rating;

    @Column(name="detailed_review")
    private String detailedReview;

}