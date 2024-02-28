package com.oreillyspringboot.Config;

import com.oreillyspringboot.Entity.Coffee;
import com.oreillyspringboot.Repository.CoffeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoffeeLoader {
    private final CoffeeRepository coffeeRepository;

    public CoffeeLoader(CoffeeRepository coffeeRepository){
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    private void loadData() {
        this.coffeeRepository.saveAll(List.of(
                new Coffee("Americano"),
                new Coffee("Machiato"),
                new Coffee("Express"),
                new Coffee("Descafeinado")
        ));
    }

}
