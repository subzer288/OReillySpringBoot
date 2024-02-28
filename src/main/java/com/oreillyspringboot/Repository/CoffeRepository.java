package com.oreillyspringboot.Repository;

import com.oreillyspringboot.Entity.Coffe;
import org.springframework.data.repository.CrudRepository;

public interface CoffeRepository extends CrudRepository<Coffe, String> {
}
