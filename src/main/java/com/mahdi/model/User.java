package com.mahdi.model;


import lombok.Data;

import javax.persistence.*;

@Table(name = "user")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String displayname;

    public User() {
    }
    
}

