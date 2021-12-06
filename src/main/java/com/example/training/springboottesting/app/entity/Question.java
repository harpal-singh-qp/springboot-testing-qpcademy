package com.example.training.springboottesting.app.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "question")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="owner_id" ,insertable = false, updatable = false)
    private User ownerId;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;

    @Column(name = "question_code")
    private String questionCode;

    @Column(name = "question_text", nullable = false)
    private String questionText;

    @Column(name = "survey_id")
    private Integer surveyId;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "created_at")
    private Date createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question )) return false;
        return getId()!=0l && getId()==((Question)o).getId();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
