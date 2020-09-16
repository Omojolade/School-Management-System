package com.omolade.demo.controller;

import com.omolade.demo.model.Person;
import com.omolade.demo.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
@Controller
public class ProfileController {
    PersonService personService;

    public ProfileController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/profile")
    public String showProfile(HttpSession session, Model model) {
        Object pobj = session.getAttribute("person");
        if (pobj == null) return  "redirect:/auth/login";
        Person person = (Person) pobj;
        person.setPassword("");
        model.addAttribute("person",person);
        return "profile";

    }
}

