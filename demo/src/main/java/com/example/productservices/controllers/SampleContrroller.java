package com.example.productservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleContrroller {
    @GetMapping("/hello/{name}")
    public String SayHello(@PathVariable("name") String name){
        return "hello" + name;
    }

}
