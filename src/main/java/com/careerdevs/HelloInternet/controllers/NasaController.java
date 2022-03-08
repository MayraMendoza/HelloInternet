package com.careerdevs.HelloInternet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Nasa")
public class NasaController {

    @Autowired
    private Environment env;

//    @Value("myNasaKey")


//    private String apiKey = "vdXG8eGPuRtlZNHF9o5q13jZuoNlIE1VIcbFcSFP"; //DEMO_KEY
    private String nasaApodEndpoint = "https://api.nasa.gov/planetary/apod?api_key=";

    /*
    @description:
    * Method:GET
    * path: /apod
    * HOST : localhost:3010
    * URL: http://localhost:3010/apod
    * where is this server being hosted? this could change - depending on where it runs.
    **/
    @GetMapping("apod")
    public Object apodHandler(RestTemplate restTemplate){
        String apiKey = env.getProperty("NASA_API_KEY");
        return restTemplate.getForObject(nasaApodEndpoint + apiKey, Object.class);
    }

    @GetMapping("port")
    public  String portTest(){
        return env.getProperty("server.port");
    }

    /*
    * Method: POST
    * path: /info
    * HOST : localhost:3010
    * URL: http://localhost:3010/apod
    * where is this server being hosted? this could change - depending on where it runs.
    **/
    @PostMapping ("info")
    public String apodInfo(){
        return "Nasa APOD is a daily astro photography photo with interesting facts";
    }

//    @GetMapping("/date")
//    public Object getapodbydate(RestTemplate restTemplate, @RequestParam String date) {
//        return restTemplate.getForObject(nasaApodEndpoint + "&" + date, Object.class);
//    }



}
