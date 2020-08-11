package com.shop.demo.controllers;

import com.shop.demo.model.User;
import com.shop.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {


    @Autowired
    private UserService userService;

    /*@Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }*/

    @GetMapping(value = "/users")
    public ModelAndView getUsersView(){
        return new ModelAndView("users","allUsers", userService.getAllUsers());
    }

    @PostMapping(value = "/adduser")
    public String getRegisterView(){
        return "registerView";
    }

    @PostMapping(value = "/registration-process")
    public String addUser(@RequestParam(name = "name") String name,
                          @RequestParam(name = "surname") String surname,
                          @RequestParam(name = "password")String password,
                          @RequestParam(name = "login")String login){

        User newUser = User.builder()
                .name(name)
                .surname(surname)
                .login(login)
                .password(password)
                .enabled(true)
                .build();

        userService.saveUser(newUser);
        return "login";
    }


}
