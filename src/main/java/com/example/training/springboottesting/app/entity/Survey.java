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
@Table(name = "survey")
public class Survey implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name="owner_id" ,insertable = false, updatable = false)
    private User owner;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

    @Column(name = "name")
    private String name;

    @Column(name = "owner_id" )
    private long ownerId;

    @Column(name = "title")
    private String title;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "updated_by")
    private long updatedBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Survey)) return false;
        return getId()!=0l && getId()==((Survey)o).getId();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
