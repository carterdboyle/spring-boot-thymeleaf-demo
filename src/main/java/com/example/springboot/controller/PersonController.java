package com.example.springboot.controller;

import com.example.springboot.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class PersonController {

    @GetMapping
    String getPeople(Model model) {
        model.addAttribute("something", "this is coming from the controller");
        model.addAttribute("people", Arrays.asList(
                new Person("John", 20),
                new Person("Sarah", 22),
                new Person("Simon", 23)
        ));
        return "people";
    }
}
