package com.gfg.imdbdemo.controller;

import com.gfg.imdbdemo.service.MyUserService;
import com.gfg.imdbdemo.service.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

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

    @GetMapping(value="/user")
    public Object getUserfromOauth2(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @PostMapping(value="/testFile")
    public String getFileData(HttpServletRequest request) throws ServletException, IOException, IOException, ServletException {
        Part p=request.getPart("myfile");
        InputStream inputStream=p.getInputStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        return reader.lines().collect(Collectors.joining());

    }


}

/**
 * Spring security will by default secure all the apis present in all the controllers in the application.
 *
 * */