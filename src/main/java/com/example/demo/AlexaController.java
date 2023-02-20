package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alexa")
public class AlexaController {
    @GetMapping
    public String sayHello() {
        return "Hello, World!";
    }
}
