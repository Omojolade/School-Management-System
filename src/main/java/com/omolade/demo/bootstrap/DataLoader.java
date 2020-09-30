package com.omolade.demo.bootstrap;

import com.omolade.demo.model.Person;
import com.omolade.demo.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
    PersonService personService;
    public DataLoader(PersonService personService) {
        this.personService = personService;
    }
    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
         Person person = personService.getPersonById(1L);
        log.info("in onApp event");
        if (person == null) {
            person = new Person();
            person.setFirstName("Omolade");
            person.setLastName("Omololu");
            person.setEmail("admin@admin.com");
            person.setPassword("admin");
            person.setRole("Admin");

            personService.addPerson(person);
            log.info("created person");
        }
    }
}