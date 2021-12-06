package com.example.training.springboottesting.app.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "answer")
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name="question_id" ,insertable = false, updatable = false)
    private Question question;

    @Column(name = "question_id")
    private long questionId;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer )) return false;
        return getId()!=0l && getId()==((Answer)o).getId();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
