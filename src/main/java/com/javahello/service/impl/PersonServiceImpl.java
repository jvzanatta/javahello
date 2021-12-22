package com.javahello.service.impl;

import com.javahello.model.Person;
import com.javahello.repository.PersonRepository;
import com.javahello.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findByName(String name) {
        return personRepository.findByName(name);
    }

//    @Override
//    public Person findById(String id) {
//        return personRepository.findById(id);
//    }

    @Override
    public Person saveOrUpdatePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePersonById(String id) {
        personRepository.deleteById(id);
    }
}
