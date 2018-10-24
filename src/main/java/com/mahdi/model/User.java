package com.mahdi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleId", nullable = false)
    @JsonIgnore
    private Role role;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//    private Set<Contact> contacts;

    private String username;
    private String password;
    private String displayname;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String displayname,Role role) {
        this.role = role;
        this.username = username;
        this.password = password;
        this.displayname = displayname;
    }
}

