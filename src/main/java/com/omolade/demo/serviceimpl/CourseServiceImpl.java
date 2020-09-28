package com.omolade.demo.serviceimpl;

import com.omolade.demo.model.Course;
import com.omolade.demo.model.Person;
import com.omolade.demo.repository.CourseRepository;
import com.omolade.demo.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    /*
    Add a Course
     */
    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course getCourseByCourseCode(String courseCode) {
        return courseRepository.findByCourseCode(courseCode);
    }

    /*
          Get all courses
        */
    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = (List<Course>) courseRepository.findAll();
        return courses;
    }
    /*
    Get all Courses for a single person
    * */
    @Override
    public List<Course> getCoursesByPerson(Person person) {
//        List<Person> people = new ArrayList<Person>(List.of(person));
        List<Course> courses = courseRepository.findAllByPersons(person);
        Collections.reverse(courses);
        return courses;
    }
    /*
        Edit a Course
    */
//    @Override
//    public Course editCourse(Course course) {
//        return null;
//    }

    @Override
    public boolean deleteCourseById(Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course == null) return false;
        courseRepository.delete(course);
        return true;
    }


//    @Override
//    public void deleteCourse(Course course) {
//
//    }

//    @Override
//    public void deleteCourse(Course course) {
//
//    }
}
