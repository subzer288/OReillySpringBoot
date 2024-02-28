package com.oreillyspringboot;

import com.oreillyspringboot.Entity.Coffe;
import com.oreillyspringboot.Repository.CoffeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffes")
public class RestApiDemonController {
    private final CoffeRepository coffeRepository;


    public RestApiDemonController(CoffeRepository coffeRepository){
        this.coffeRepository = coffeRepository;
        this.coffeRepository.saveAll(List.of(
                new Coffe("Americano"),
                new Coffe("Machiato"),
                new Coffe("Express"),
                new Coffe("Descafeinado")
        ));
    }

    @GetMapping()
    Iterable<Coffe> getCoffes(){
//        return this.coffes;
        return this.coffeRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    Optional<Coffe> getCoffeById(@PathVariable String id){
//        for(Coffe c: this.coffes){
//            if(c.getId().equals(id))
//                return Optional.of(c);
//        }
//
        return this.coffeRepository.findById(id);
    }

    @PostMapping
    Coffe postCoffe(@RequestBody Coffe coffe){
//        this.coffes.add(coffe);
//        return coffe;
        return this.coffeRepository.save(coffe);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<Coffe> putCoffe(@PathVariable String id, @RequestBody Coffe coffe){
//        int coffeIndex = -1;
//        for(Coffe c: this.coffes){
//            if(c.getId().equals(id)){
//                coffeIndex = this.coffes.indexOf(c);
//                this.coffes.set(coffeIndex, coffe);
//            }
//        }
//        return coffeIndex == -1 ? postCoffe(coffe) : coffe;
        return (!coffeRepository.existsById(id))
                ? new ResponseEntity<>(this.coffeRepository.save(coffe), HttpStatus.CREATED)
                : new ResponseEntity<>(this.coffeRepository.save(coffe), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    void deleteCoffe(@PathVariable String id){
//        this.coffes.removeIf(c -> c.getId().equals(id));
        this.coffeRepository.deleteById(id);
    }

}
