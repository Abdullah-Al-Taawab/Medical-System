package com.example.medical_system.controller;


import com.example.medical_system.entity.Users;
import com.example.medical_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @Autowired
    private UserRepository userRepository;

   @Autowired
   private PasswordEncoder passwordEncoder;

    @PostMapping(value = "/req/signup", consumes = "application/json")
    public Users createUser(@RequestBody Users users)
    {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
         return userRepository.save(users);
    }
}
