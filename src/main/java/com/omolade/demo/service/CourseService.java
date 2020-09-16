package com.omolade.demo.service;

import com.omolade.demo.model.Course;
import com.omolade.demo.model.Person;

import java.util.List;

public interface CourseService {
    Course addCourse(Course course);
    Course getCourseById(Long id);
    Course getCourseByCourseCode(String courseCode);
    List<Course> getAllCourses();
    List<Course> getCoursesByPerson(Person person);
    Course editCourse(Course course);
    boolean deleteCourseById(Long id);

//    void deleteCourse(Course course);
}
