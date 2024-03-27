package com.oreillyspringbootredis;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@EnableScheduling
@Component
public class PlaneFinderPoller {
    private WebClient client = WebClient.create("http://localhost:7634/aircraft");

    private final RedisConnectionFactory connectionFactory;
    private final RedisOperations<String, Aircraft> redisOperations;

    PlaneFinderPoller(RedisConnectionFactory factory, RedisOperations<String, Aircraft> operations){
        this.connectionFactory = factory;
        this.redisOperations = operations;
    }
    @Scheduled(fixedRate = 1000)
    private void pollPlanes(){
        this.connectionFactory.getConnection().serverCommands().flushDb();

        this.client.get()
                .retrieve()
                .bodyToFlux(Aircraft.class)
                .filter(plane -> !plane.getReg().isEmpty())
                .toStream()
                .forEach(ac -> System.out.println(this.redisOperations.opsForValue().get(ac)));
    }
}
