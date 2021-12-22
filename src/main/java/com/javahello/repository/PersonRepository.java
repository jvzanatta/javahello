package com.javahello.repository;

import com.javahello.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {
//    Person findById(String id);

    Person findByName(String name);

    List<Person> findAll();
}
