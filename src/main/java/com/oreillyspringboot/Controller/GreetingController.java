package com.oreillyspringboot.Controller;

import com.oreillyspringboot.Config.Greeting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final Greeting greeting;

    public GreetingController(Greeting greeting){
        this.greeting = greeting;
    }

    @GetMapping
    String getGreeting(){
        return this.greeting.getName();
    }

    @GetMapping("/coffee")
    String getNameAndCoffee(){
        return this.greeting.getCoffee();
    }
}
