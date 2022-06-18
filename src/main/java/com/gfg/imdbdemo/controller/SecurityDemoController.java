package com.gfg.imdbdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityDemoController {

    @GetMapping("/greet")
    public String greetUser(@RequestParam String user){
        return "Hello " + user;
    }
}

/**
 * Spring security will by default secure all the apis present in all the controllers in the application.
 *
 * */