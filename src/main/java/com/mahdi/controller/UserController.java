package com.mahdi.controller;


import com.mahdi.common.Constants;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/"+ Constants.KEY_USER_CONTROLLER)
public class UserController {



    @RequestMapping(path = "/home",method = RequestMethod.GET)
    public String home(){
        return "Hello World";
    }


}
