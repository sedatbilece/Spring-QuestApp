package com.project.questapp.entities;

import javax.persistence.*;

import lombok.Data;


@Entity
@Table(name="user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String userName;
    String password;


}