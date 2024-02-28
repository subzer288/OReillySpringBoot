package com.oreillyspringboot;

import com.oreillyspringboot.Util.Droid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
@ConfigurationPropertiesScan
public class OReillySpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(OReillySpringBootApplication.class, args);
	}

	@Bean
	@ConfigurationProperties(prefix = "droid")
	Droid createCroid(){
		return new Droid();
	}
}
