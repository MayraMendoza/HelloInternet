package com.careerdevs.HelloInternet.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@RestController
public class RootControllerClass {

    @GetMapping("/")
    private String rootRoute (){
        return "you requested the root route";
    }

    @GetMapping("/random")
    private int randomNumber (){
        int min = 1;
        int max = 100;
        Random randomNum = new Random();
        int generateRandomNum = min + randomNum.nextInt(max);
        return generateRandomNum;
    }

    @GetMapping ("/joke")
    private String joke(){
        String jokes[] = new String[] {"What kind of exercise do lazy people do? Diddly-squats.","What do you call a pony with a cough? A little horse!",
                "What is Forrest Gump's password? 1Forrest1.", "Why did the M&M go to school? He wanted to be a Smartie.", "What did one traffic light say to the other? Stop looking at me, I'm changing!",
                "I invented a new word today: Plagiarism."};
        int max = jokes.length -1;
        Random random = new Random();
        int generateRandomNum = random.nextInt(max);

        return jokes[generateRandomNum];



    }
}
