package com.oreillyspringboot;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffes")
public class RestApiDemonController {
    private List<Coffe> coffes = new ArrayList<>();

    public RestApiDemonController(){
        this.coffes.addAll(List.of(
                new Coffe("Americano"),
                new Coffe("Machiato"),
                new Coffe("Express"),
                new Coffe("Descafeinado")
        ));
    }

    @GetMapping()
    Iterable<Coffe> getCoffes(){
        return this.coffes;
    }

    @GetMapping(value = "/{id}")
    Optional<Coffe> getCoffeById(@PathVariable String id){
        for(Coffe c: this.coffes){
            if(c.getId().equals(id))
                return Optional.of(c);
        }
        return Optional.empty();
    }

    @PostMapping
    Coffe postCoffe(@RequestBody Coffe coffe){
        this.coffes.add(coffe);
        return coffe;
    }

    @PutMapping(value = "/{id}")
    Coffe putCoffe(@PathVariable String id, @RequestBody Coffe coffe){
        int coffeIndex = -1;
        for(Coffe c: this.coffes){
            if(c.getId().equals(id)){
                coffeIndex = this.coffes.indexOf(c);
                this.coffes.set(coffeIndex, coffe);
            }
        }
        return coffeIndex == -1 ? postCoffe(coffe) : coffe;
    }

    @DeleteMapping(value = "/{id}")
    void deleteCoffe(@PathVariable String id){
        this.coffes.removeIf(c -> c.getId().equals(id));
    }

}
