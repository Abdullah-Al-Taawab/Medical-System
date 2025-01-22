package com.example.medical_system.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    @GetMapping("/req/login")
    public String login()
    {
        return "login";
    }

    @GetMapping("/req/signup")
    public String signup()
    {
        return "signup";
    }
}
