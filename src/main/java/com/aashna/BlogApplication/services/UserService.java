package com.aashna.BlogApplication.services;

import com.aashna.BlogApplication.model.User;

import java.util.List;

public interface UserService {
    public String createUser(User user);
    public String updateUser(User user);
    public User getUserById(Integer userId);
    public String deleteUser(Integer userId);
    public List<User> getAllUsers();
}
