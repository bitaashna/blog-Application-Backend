package com.aashna.BlogApplication.controllers;

import com.aashna.BlogApplication.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    User user;

    @GetMapping("/{userId}")
    public User getUser(String userId) {
        return user;
    }

    @PostMapping
    public String createUserDetail(@RequestBody User user){
        this.user=user;
        return "User created Successfully";
    }

    @PutMapping
    public String updateUserDetails(@RequestBody User user){
        this.user=user;
        return "User updated successfully";
    }

    @DeleteMapping("/{userId}")
    public String deleteUserDetails(String userId){
        this.user=null;
        return "User Deleted";
    }
}
