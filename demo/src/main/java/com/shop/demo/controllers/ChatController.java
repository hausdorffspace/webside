package com.shop.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @GetMapping(value = "/chat")
    public String getChar(){
        return "chat";
    }

}
