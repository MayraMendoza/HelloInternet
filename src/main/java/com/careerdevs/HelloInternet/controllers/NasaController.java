package com.careerdevs.HelloInternet.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Nasa")
public class NasaController {

    @Value("myNasaKey")

    private String apiKey = "vdXG8eGPuRtlZNHF9o5q13jZuoNlIE1VIcbFcSFP";
    private String nasaApodEndpoint = "https://api.nasa.gov/planetary/apod?api_key=" + apiKey;

    @GetMapping("/apod")
    public Object apodHandler(RestTemplate restTemplate){
        return restTemplate.getForObject(nasaApodEndpoint, Object.class);
    }

//    @GetMapping("/date")
//    public Object getapodbydate(RestTemplate restTemplate, @RequestParam String date) {
//        return restTemplate.getForObject(nasaApodEndpoint + "&" + date, Object.class);
//    }



}
