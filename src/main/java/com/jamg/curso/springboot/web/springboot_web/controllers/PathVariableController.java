package com.jamg.curso.springboot.web.springboot_web.controllers;

import com.jamg.curso.springboot.web.springboot_web.models.User;
import com.jamg.curso.springboot.web.springboot_web.models.dto.ParamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.code}")
    private Integer code;
    @Value("${config.username}")
    private String username;
    // @Value("${config.message}")
    // private String message;
    @Value("${config.lisOfValues}")
    private List<String> listOfValues;
    @Value("#{'${config.lisOfValues}'.split(',')}")
    private List<String> valueList;
    @Value("#{'${config.lisOfValues}'.toUpperCase()}")
    private String valueString;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;
    @Value("#{${config.valuesMap}.product}")
    private String product;
    @Value("#{${config.valuesMap}.price}")
    private Long price;

    @Autowired
    private Environment environment;


    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable() String message) {

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {

        Map<String, Object> params = new HashMap<>();
        params.put("product", product);
        params.put("id", id);
        return params;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {

        user.setName(user.getName().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values(
            @Value("${config.message}") String message
    ) {
        Map<String, Object> json = new HashMap<>();
        Long code2 = environment.getProperty("config.code", Long.class);
        json.put("code", code);
        json.put("username", username);
        json.put("message", message);
        json.put("listOfValues", listOfValues);
        json.put("valueList", valueList);
        json.put("valueString", valueString);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);
        json.put("message2", environment.getProperty("config.message"));
        json.put("code2", code2);
        // json.put("code2", environment.getProperty("config.code", Long.class));
        // json.put("code2", Integer.valueOf(environment.getProperty("config.code")));
        return json;
    }

}
