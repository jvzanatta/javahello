package com.javahello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping(value = "/hello")
    public String sayHello() {
        return "World";
    }
}
