package com.oreillyspringboot.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Coffee {
    @Id
    private String id;

//    Due To the non-arg constructor all member variables must be mutable
//    private final String id;

    private String name;

    //Java Persistence API requires a non-arg constructor
    public Coffee(){}

    public Coffee(String id, String name){
        this.id = id;
        this.name = name;
    }
    public Coffee(String name){
        this(UUID.randomUUID().toString(), name);
    }


    public String getName(){ return this.name; }
    public void setName(String name){
        this.name = name;
    }
    public String getId(){
        return this.id;
    }
//    Mutator method for id dou to it is nonfinal
    public void setId(String id){ this.id = id; }
}
