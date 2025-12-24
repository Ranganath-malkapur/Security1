package com.Unique.SpringSecurityApp3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Unique.SpringSecurityApp3.Entity.User;
import com.Unique.SpringSecurityApp3.Repository.UserRepository;

@RestController
public class RegisterController {
    
    @Autowired
    private UserRepository uRepository;

    @Autowired
    private PasswordEncoder pEncoder;

    @PostMapping("/register")
    public String register(@RequestBody User user){
        String rawPassword=user.getPassword();
        
        user.setPassword(pEncoder.encode(rawPassword));
        uRepository.save(user);

        return "Register Successfully";
    }

    @GetMapping("/check")
    public String Check(){
         return "Login Successfully";
    }
}
