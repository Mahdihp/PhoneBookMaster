package com.mahdi.controller;


import com.mahdi.constant.Constants;
import com.mahdi.model.User;
import com.mahdi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/" + Constants.KEY_USER_CONTROLLER)
public class UserController {


    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Secured("USER")
    @GetMapping("/home")
    public User home() {
        return new User("Mahdi", "password");
    }

    @ResponseBody
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @PostMapping("/login")
    public void login(@RequestParam("username") String userName, @RequestParam("password") String passWord) {
        System.out.println(userName);
        System.out.println(passWord);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("userid") String userId) {

    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {

    }

    @GetMapping("/user")
    public void read(@RequestParam("userid") Long userId) {

    }

    @PutMapping("/update")
    public void update(){

    }


}
