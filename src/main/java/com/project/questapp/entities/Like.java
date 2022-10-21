package com.project.questapp.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="like")
@Data
public class Like {

    @Id
    Long id;
    Long postId;
    Long userId;
}
