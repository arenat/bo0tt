package com.boott.boott.repository;

import com.boott.boott.entities.People;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<People, Integer> {
}
