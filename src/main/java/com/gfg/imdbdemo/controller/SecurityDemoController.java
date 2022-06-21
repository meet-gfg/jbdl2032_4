package com.gfg.imdbdemo.controller;

import com.gfg.imdbdemo.service.MyUserService;
import com.gfg.imdbdemo.service.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class SecurityDemoController {

    @Autowired
    MyUserService userService;

    @GetMapping("/admin/greet")
    public String greetAdmin(){
        String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        return "Hello " + userName;
    }

     @GetMapping("/admin/greet1")
    public String greetAdmin1(@RequestParam String user){
        return "Hello " + user;
    }

/**
 * SecurityContextHolder will hold the context for the Spring security. It also holds the authentication object
 * to get the user details.
 * */

    @GetMapping("/user/greet")
    public String greetUser(){
        String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        return "Hello " + userName;
    }


    @PostMapping(value = "/signup")
    public Boolean addUser(@RequestBody UserRequest userRequest){
        try{
            userService.addUser(userRequest.toMyUser());
            return true;
        }catch (Exception ex){
            //log the exception
            return false;
        }
    }
}

/**
 * Spring security will by default secure all the apis present in all the controllers in the application.
 *
 * */