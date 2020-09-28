package com.omolade.demo.repository;

import com.omolade.demo.model.Course;
import com.omolade.demo.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,Long> {
//    Course (Long courseId);
   List<Course> findAllByPersons(Person person);
    Course findByCourseCode(String courseCode);
}
