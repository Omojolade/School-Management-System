package com.omolade.demo.controller;

import com.omolade.demo.model.Person;
import com.omolade.demo.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class SignupController {
    private PersonService personService;


    public SignupController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("person", new Person());
        return "signup";
    }
    @PostMapping("/signup")
    public String signup(@Valid Person person, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getFieldError().getDefaultMessage());
            return "redirect:/auth/signup";
        }
        personService.addPerson(person);
        //return "redirect:/auth/login";
        return "login";
    }
}
