package com.example.productservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleContrroller {
    @GetMapping("/hello/{name}/{number}")
    public String SayHello(@PathVariable("name") String name,@PathVariable("number") int numberTimes){
        String response = "";
        for(int i = 0;i<numberTimes;i++){
            String s = "hello" + name + "<br>";
            response += s;
        }

        return response;
    }

}
