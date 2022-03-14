package com.careerdevs.HelloInternet.controllers;

import com.careerdevs.HelloInternet.models.ApodModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/apod")
public class NasaController {

    @Autowired
    private Environment env;

//    @Value("myNasaKey")


    private String nasaApodEndpoint = "https://api.nasa.gov/planetary/apod?api_key=";

    /*
    @description:
    * Method:GET
    * path: /apod
    * HOST : localhost:3010
    * URL: http://localhost:3010/api/apod/today
    * where is this server being hosted? this could change - depending on where it runs.
    **/
    @GetMapping("today")
    public ApodModel apodHandler(RestTemplate restTemplate){
        String apodKey = env.getProperty("NASA_API_KEY", "DEMO_KEY");
        String URL = "https://api.nasa.gov/planetary/apod?api_key=" + apodKey;
        ApodModel response = restTemplate.getForObject(URL, ApodModel.class);

        return response;
    }

    // URL: http://localhost:3010/api/apod/Image

//    @GetMapping("Image")
//    private String apodImage(RestTemplate restTemplate){
//        String apodKey = env.getProperty("NASA_API_KEY", "DEMO_KEY");
//        String URL = "https://api.nasa.gov/planetary/apod?api_key=" + apodKey;
//        ApodModel response = restTemplate.getForObject(URL, ApodModel.class);
//
//        return response.getUrl();
//    }

    // URL: http://localhost:3010/api/apod/Image
    // experimenting with path variables and request parameters

    @GetMapping("/image")
    private String apodImage(
            RestTemplate restTemplate,
            @RequestParam("year") String year,
            @RequestParam("month") String month,
            @RequestParam("day") String day
            ){
        String date = year + "-" + month + "-"+ day;
        String apodKey = env.getProperty("NASA_API_KEY", "DEMO_KEY");
        String URL = "https://api.nasa.gov/planetary/apod?";
        URL += "api_key=" + apodKey;
        URL += "&date=" + date;
        ApodModel response = restTemplate.getForObject(URL, ApodModel.class);


        return response.getUrl();
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
