package com.shop.demo.controllers;

import com.shop.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class IndexController {

    @RequestMapping(value = {"/", "index"})
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String getLoginView(){
        return "login";
    }

    @GetMapping("/getUserName")
    public @ResponseBody User getUserName(Principal principal){
        return User.builder().name(principal.getName()).build();
    }

    @GetMapping("/getIndex")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }

}
