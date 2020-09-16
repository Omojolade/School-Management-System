package com.omolade.demo.controller;

import com.omolade.demo.model.Person;
import com.omolade.demo.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/auth/")
public class LoginController {
    private PersonService personService;

    public LoginController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("home")
    public String home() {
        return "home";
    }

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("invalid", null);
        return "login";
    }
    @PostMapping("login")
    public String login(HttpSession session, @Valid Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("result has errors");
            System.out.println(result.getFieldError().getDefaultMessage());
            return "login";
        }

        Person addedPerson = personService.getPersonByEmail(person.getEmail());

        if(addedPerson == null|| !addedPerson.getPassword().equals(person.getPassword())){
            model.addAttribute("invalid", "Invalid username or password");
            return "login";
        }
        addedPerson.setPassword("");
        //System.out.println(person);
        session.setAttribute("person",addedPerson);
        model.addAttribute("person",addedPerson);

        if(person.getRole().toLowerCase().equals("admin")) {
            return "admin";
        } else {
            return "home";
        }
    }

}
