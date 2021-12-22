package com.javahello.controller;

import com.javahello.dto.PersonDTO;
import com.javahello.model.Person;
import com.javahello.service.PersonService;
import com.javahello.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PersonRestController {
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/people/all")
    public List<PersonDTO> getAllPeople() {
        return ObjectMapperUtils.mapAll(personService.findAll(), PersonDTO.class);
    }

    @GetMapping(value = "/people/byName/{name}")
    public PersonDTO getPersonByName(@PathVariable("name") String name) {
        return ObjectMapperUtils.map(personService.findByName(name), PersonDTO.class);
    }

    @PostMapping(value = "/people/save")
    public ResponseEntity<?> saveOrUpdatePerson(@RequestBody PersonDTO personDTO) {
        personService.saveOrUpdatePerson(ObjectMapperUtils.map(personDTO, Person.class));
        return new ResponseEntity("Person saved", HttpStatus.OK);
    }

    @DeleteMapping(value = "/people/delete/{name}")
    public ResponseEntity<?> deletePersonByName(@PathVariable String name) {
        personService.deletePersonById(personService.findByName(name).getId());
        return new ResponseEntity("Person deleted", HttpStatus.OK);
    }

}
