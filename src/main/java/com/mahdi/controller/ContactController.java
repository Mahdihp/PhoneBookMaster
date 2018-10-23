package com.mahdi.controller;


import com.mahdi.common.Constants;
import com.mahdi.model.Contact;
import com.mahdi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/"+ Constants.KEY_CONTACT_CONTROLLER)
public class ContactController {


    private ContactRepository contactRepository;

    @Autowired
    public ContactController(ContactRepository userRepository){
        this.contactRepository = userRepository;
    }

    @GetMapping("/home")
    public Contact home(){
        return new Contact("Mahdi","password","","","");
    }

    @ResponseBody
    @GetMapping("/list")
    public List<Contact> readAll(){
        return contactRepository.findAll();
    }


}
