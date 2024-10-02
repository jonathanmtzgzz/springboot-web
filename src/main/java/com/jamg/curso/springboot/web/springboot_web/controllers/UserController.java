package com.jamg.curso.springboot.web.springboot_web.controllers;

import com.jamg.curso.springboot.web.springboot_web.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {

        User user = new User("Jonathan", "Gonzalez");
        user.setEmail("jonathan@hotmail.com");
        model.addAttribute("title", "Hola Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {

        // List<User> users = new ArrayList<>();
        // List<User> users = Arrays.asList();
        // model.addAttribute("users", users);
        model.addAttribute("title", "List of users");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel() {
        return Arrays.asList(
                new User("Jonathan", "Gonzalez"),
                new User("Cristofer", "Soto", "cristofer@hotmail.com"),
                new User("Ever", "Martinez"),
                new User("Gabriel", "Rodriguez", "gabriel@gmail.com")
        );
    }
}
