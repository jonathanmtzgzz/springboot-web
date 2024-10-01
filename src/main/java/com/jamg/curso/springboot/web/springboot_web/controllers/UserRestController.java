package com.jamg.curso.springboot.web.springboot_web.controllers;


// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserRestController {

    // @RequestMapping(path="/details", method = RequestMethod.GET)
    @GetMapping(path="/details")
    public Map<String, Object> details() {
        Map<String, Object> body = new HashMap<>();
        body.put("title", "Hola Spring Boot");
        body.put("name", "Jonathan");
        body.put("lastname", "Gonzalez");
        return body;
    }
}
