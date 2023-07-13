package com.aashna.BlogApplication.controllers;

import com.aashna.BlogApplication.model.User;
import com.aashna.BlogApplication.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Read user detail with particular id
    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Integer userId) {
        return userService.getUserById(userId);
    }

    //Read all user details from db
    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public String createUserDetail(@RequestBody User user){
        userService.createUser(user);
        return "User created Successfully";
    }

    @PutMapping
    public String updateUserDetails(@RequestBody User user){
        userService.updateUser(user);
        return "User updated successfully";
    }

    @DeleteMapping("/{userId}")
    public String deleteUserDetails(@PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
        return "User Deleted";
    }
}
