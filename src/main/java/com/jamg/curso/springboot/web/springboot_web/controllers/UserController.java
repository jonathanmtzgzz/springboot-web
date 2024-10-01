package com.jamg.curso.springboot.web.springboot_web.controllers;

import com.jamg.curso.springboot.web.springboot_web.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Jonathan", "Gonzalez");

        model.addAttribute("title", "Hola Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }
}
