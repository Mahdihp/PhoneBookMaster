package com.mahdi.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "contacts")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    private String firstName;
    private String lastName;
    private String homePhone;
    private String mobile;
    private String email;

    public Contact() {
    }

    public Contact(User user, String firstName, String lastName, String homePhone, String mobile, String email) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.mobile = mobile;
        this.email = email;
    }
}
