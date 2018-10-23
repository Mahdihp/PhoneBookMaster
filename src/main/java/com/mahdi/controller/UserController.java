package com.mahdi.controller;


import com.mahdi.common.Constants;
import com.mahdi.model.User;
import com.mahdi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(path = "/"+ Constants.KEY_USER_CONTROLLER)
public class UserController {


    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/home")
    public User home(){
        return new User("Mahdi","password");
    }

    @ResponseBody
    @GetMapping("/list")
    public List<User> readAll(){
        return userRepository.findAll();
    }


}
