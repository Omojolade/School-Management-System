package com.omolade.demo.repository;

import com.omolade.demo.model.Course;
import com.omolade.demo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository <Person, Long>{
    Optional<Person> findPersonByEmail (String email);
  List<Person> findAllPersonByRole(String role);
//    List<Person> findAllByRoleAndAge

}
