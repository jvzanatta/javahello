package com.javahello.service;

import com.javahello.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();

//    Person findById(String id);

    Person findByName(String name);

    Person saveOrUpdatePerson(Person person);

    void deletePersonById(String id);
}
