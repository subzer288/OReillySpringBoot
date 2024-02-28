package com.oreillyspringboot.Repository;

import com.oreillyspringboot.Entity.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {
}
