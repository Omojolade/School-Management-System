package com.omolade.demo.controller;

import com.omolade.demo.model.Course;
import com.omolade.demo.model.Person;
import com.omolade.demo.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AdminController {
    private PersonService personService;


    public AdminController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping("/admin")
    public String studentreg(Model model) {
        model.addAttribute("person", new Person());
        return "admin";
    }
    @PostMapping("/admin")
    public String studentreg(@Valid Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println(result.getFieldError().getDefaultMessage());
            return "redirect:/auth/admin";
        }
        Person gottenPerson = personService.getPersonByEmail(person.getEmail());

        if(gottenPerson != null){
            model.addAttribute("invalid", "Student already exist");
            return "admin";
        }
        personService.addPerson(person);
        model.addAttribute("success", "Student Registration Successful");
        return "admin";
    }

    @GetMapping("/student")
    public String getAllPersons(Model model) {
        model.addAttribute("persons", personService.getAllPersonByRole("student"));

        return "student";
    }


    @GetMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("person", new Person());
        Person person = personService.getPersonById(id);
        model.addAttribute("person", person);
//        personService.editPerson(person, personupdate.);
        return "update";
    }

    @PostMapping("/edit/{id}/{field}")
    public String editPerson(@PathVariable("id") Long id, @PathVariable("field") String field, Model model, @Valid Person person) {

        Person gottenPerson = personService.getPersonById(id);
        gottenPerson.setEmail(person.getEmail());
        personService.editPerson(gottenPerson);
        model.addAttribute("update", "Update successful");

        model.addAttribute("persons", personService.getAllPersonByRole("student"));


////        model.addAttribute("person", new Person());
//        Person person = personService.getPersonById(id);
//        model.addAttribute("person", person);
//        personService.editPerson(person, personupdate.);
        return "student";
    }



}
