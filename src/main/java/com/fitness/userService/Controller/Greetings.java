package com.fitness.userService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fit")
public class Greetings {

    @GetMapping("/greet")
    public String greet(){
        return "Welcome to the fitness AI app";
    }
}
