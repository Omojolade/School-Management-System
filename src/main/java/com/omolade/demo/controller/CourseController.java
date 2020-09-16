package com.omolade.demo.controller;

import com.omolade.demo.model.Course;
import com.omolade.demo.model.Person;
import com.omolade.demo.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    /*
    Add new courses
     */
    @PostMapping("/new")
    public String addCourse(HttpSession session, @Valid Course course) {
        Object personObj = session.getAttribute("person");

        if(personObj==null) return "redirect:/auth/login";

        List<Person> people = course.getPersons();

        people.add((Person) personObj);

        course.setPersons(people);



        courseService.addCourse(course);
        return "redirect:/courses/";
    }


    @GetMapping("/")
    public String getAllCourses(Model model, HttpSession session) {
        Object personObj =  session.getAttribute("person");
        if(personObj==null) return "redirect:/auth/login";
        model.addAttribute("person", (Person) personObj);
        model.addAttribute("courses", courseService.getAllCourses());

//        List<Course> courses =

//        model.addAttribute("studentcourses", courseService.getCoursesByPerson((Person) personObj));
        model.addAttribute("mewCourse",new Course());
        return "coursereg";
    }

    @PostMapping("delete/{id}")
    public String deleteCourseById(@PathVariable("id") long id, Model model) {
        Course course = courseService.getCourseById(id);
        courseService.deleteCourseById(id);
        model.addAttribute("courses", courseService.getAllCourses());
        return "redirect:/courses/";
    }



}
