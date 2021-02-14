package com.core.federix.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public List<String> getAll() {
        List<String> users = new ArrayList<>();
        users.add("ftorres");
        users.add("jperez");
        users.add("pepito");
        return users;
    }
}
