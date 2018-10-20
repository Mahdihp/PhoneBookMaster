package com.mahdi.model;


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
    private Role role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Contact> contacts;

    private String username;
    private String password;
    private String displayname;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Role role, Set<Contact> contacts, String username, String password, String displayname) {
        this.role = role;
        this.contacts = contacts;
        this.username = username;
        this.password = password;
        this.displayname = displayname;
    }
}

