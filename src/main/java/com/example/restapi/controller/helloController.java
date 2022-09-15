package com.example.restapi.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//ensure class is added to the container when class is started -component
@RestController
public class helloController {

    //@RequestMapping(value = "/api", method = RequestMethod.GET)
    //above is abit verbose;
    @GetMapping("/api")
    public String helloWorld(){

        return "Welcome to my project";

    }
}
