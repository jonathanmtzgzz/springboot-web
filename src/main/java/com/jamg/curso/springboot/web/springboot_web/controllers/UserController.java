package com.jamg.curso.springboot.web.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        model.addAttribute("title", "Hola Spring Boot");
        model.addAttribute("name", "Jonathan");
        model.addAttribute("lastname", "Martinez");
        return "details";
    }
}
