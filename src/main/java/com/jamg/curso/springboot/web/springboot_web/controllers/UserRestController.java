package com.jamg.curso.springboot.web.springboot_web.controllers;


// import org.springframework.ui.Model;
import com.jamg.curso.springboot.web.springboot_web.models.User;
import com.jamg.curso.springboot.web.springboot_web.models.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class UserRestController {

    // @RequestMapping(path="/details", method = RequestMethod.GET)
    @GetMapping(path = "/details")
    public UserDto details() {

        User user = new User("Jonathan", "Gonzalez");
        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTitle("Hola Spring Boot");

        // Map<String, Object> body = new HashMap<>();
        // body.put("title", "Hola Spring Boot");
        // body.put("user", user);
        return userDto;
    }

    @GetMapping("/list")
    public List<User> list() {
        User user = new User("Jonathan", "Martinez");
        User user2 = new User("Cristofer", "Acosta");
        User user3 = new User("Ever", "Martinez");

        // List<User> users = Arrays.asList(user, user2, user3);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);
        return users;
    }
}
