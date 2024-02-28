package com.oreillyspringboot.Controller;

import com.oreillyspringboot.Entity.Coffee;
import com.oreillyspringboot.Repository.CoffeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {
    private final CoffeeRepository coffeeRepository;


    public CoffeeController(CoffeeRepository coffeeRepository){
        this.coffeeRepository = coffeeRepository;
    }

    @GetMapping()
    Iterable<Coffee> getCoffees(){
//        return this.coffees;
        return this.coffeeRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id){
//        for(Coffee c: this.coffees){
//            if(c.getId().equals(id))
//                return Optional.of(c);
//        }
//
        return this.coffeeRepository.findById(id);
    }

    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee){
//        this.coffees.add(coffee);
//        return coffee;
        return this.coffeeRepository.save(coffee);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee){
//        int coffeeIndex = -1;
//        for(Coffee c: this.coffees){
//            if(c.getId().equals(id)){
//                coffeeIndex = this.coffees.indexOf(c);
//                this.coffees.set(coffeeIndex, coffee);
//            }
//        }
//        return coffeeIndex == -1 ? postCoffee(coffee) : coffee;
        return (!coffeeRepository.existsById(id))
                ? new ResponseEntity<>(this.coffeeRepository.save(coffee), HttpStatus.CREATED)
                : new ResponseEntity<>(this.coffeeRepository.save(coffee), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    void deleteCoffee(@PathVariable String id){
//        this.coffees.removeIf(c -> c.getId().equals(id));
        this.coffeeRepository.deleteById(id);
    }

}
