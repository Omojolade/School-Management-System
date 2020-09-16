package com.omolade.demo.service;

import com.omolade.demo.model.Person;

import java.util.Optional;

public interface PersonService {

    Person addPerson(Person person);
    Person getPersonById(Long id);
    Person getPersonByEmail(String email);

}
