package com.mahdi.controller;


import com.mahdi.common.Constants;
import com.mahdi.model.User;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.URI;


@RestController
@RequestMapping(path = "/"+ Constants.KEY_USER_CONTROLLER)
public class UserController {


    @GetMapping("/home")
    public User home(){
        return new User("Mahdi","password");
    }


}
