package com.mahdi.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "privileges")
public class Privilege implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long privilegeId;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "privileges")
    private Set<Role> roles;

    public Privilege() {
    }
}
