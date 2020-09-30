package com.omolade.demo.service;

import com.omolade.demo.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PersonService {

    Person addPerson(Person person);
    Person getPersonById(Long id);
    Person getPersonByEmail(String email);
  List<Person> getAllPersons();
    List<Person> getAllPersonByRole(String role);
    Person editPerson(Person person);
}
