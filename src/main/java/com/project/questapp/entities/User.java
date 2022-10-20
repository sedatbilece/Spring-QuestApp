package com.project.questapp.entities;

import javax.persistence.Table;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
@Table(name="user")
@Data
public class User {

    @Id
    Long id;
    String userName;
    String password;


}