package com.project.questapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="posts")
@Data
public class Post {
    @Id
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)//while post loading not load the user (Lazy)
    @JoinColumn(name = "post_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)

    User user;

    String title;
    @Lob
    @Column(columnDefinition = "text")
    String text;
}
