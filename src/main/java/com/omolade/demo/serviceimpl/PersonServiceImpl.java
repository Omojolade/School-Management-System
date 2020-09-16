package com.omolade.demo.serviceimpl;

import com.omolade.demo.model.Person;
import com.omolade.demo.repository.PersonRepository;
import com.omolade.demo.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PersonServiceImpl implements PersonService {
   PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }



    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Person getPersonByEmail(String email) {
        return personRepository.findPersonByEmail(email).orElse(null);
    }


}
