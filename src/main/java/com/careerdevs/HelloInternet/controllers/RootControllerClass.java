package com.careerdevs.HelloInternet.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootControllerClass {

    @GetMapping("/")
    private String rootRoute (){
        return "you requested the root route";
    }
}
