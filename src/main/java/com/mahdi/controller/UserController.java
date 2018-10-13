package com.mahdi.controller;


import com.mahdi.common.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path = "/"+ Constants.KEY_USER_CONTROLLER)
public class UserController {



    @ResponseBody
    @RequestMapping(path = "/home",method = RequestMethod.GET)
    public String home(){
        return "Hello World";
    }


}
