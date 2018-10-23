package com.mahdi.repository;

import com.mahdi.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {

    Contact findContactByFirstName(String firstName);
    Contact findContactByLastName(String lastName);
    Contact findContactByContactId(Long id);
}
