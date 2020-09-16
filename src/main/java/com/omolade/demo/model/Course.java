package com.omolade.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table (name= "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String courseCode;
    private String courseName;

    @ManyToMany
    List<Person> persons = new ArrayList<>();
}
/*
Object personObj = session.getAttribute("person");
        if(personObj==null) return "redirect:/auth/login";

        String code = course.getCourseCode();
        Course actualCourse = courseService.getCourseByCourseCode(code);

        List<Person> people = actualCourse.getPersons();

        people.add((Person) personObj);

        actualCourse.setPersons(people);



        courseService.addCourse(actualCourse);
 */