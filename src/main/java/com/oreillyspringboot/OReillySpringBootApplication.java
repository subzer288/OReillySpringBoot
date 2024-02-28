package com.oreillyspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class OReillySpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(OReillySpringBootApplication.class, args);
	}

}

class Coffe {
	private final String id;
	private String name;

	public Coffe(String id, String name){
		this.id = id;
		this.name = name;
	}
	public Coffe(String name){
		this(UUID.randomUUID().toString(), name);
	}

	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getId(){
		return this.id;
	}
}
