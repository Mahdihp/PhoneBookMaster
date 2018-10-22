package com.mahdi.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @OneToMany(mappedBy = "role")
    private Set<User> users;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "role_privilege",
            joinColumns = @JoinColumn(name = "roleId"),
            inverseJoinColumns = @JoinColumn(name = "privilegeId"))
    private Set<Privilege> privileges;

    private String name;

    public Role() {
    }

    public Role(Set<User> users, Set<Privilege> privileges, String name) {
        this.users = users;
        this.privileges = privileges;
        this.name = name;
    }
}
