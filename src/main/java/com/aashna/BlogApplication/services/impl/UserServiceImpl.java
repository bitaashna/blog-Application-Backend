package com.aashna.BlogApplication.services.impl;

import com.aashna.BlogApplication.model.User;
import com.aashna.BlogApplication.repositories.UserRepo;
import com.aashna.BlogApplication.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public String createUser(User user) {
        //data via repository layer saved into db
        userRepo.save(user);
        return "Success";
    }

    @Override
    public String updateUser(User user) {
        userRepo.save(user);
        return "Success";
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepo.findById(userId).get();
    }

    @Override
    public String deleteUser(Integer userId) {
        userRepo.deleteById(userId);
        return "Success";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
