package com.aashna.BlogApplication.services;

import com.aashna.BlogApplication.payloads.UserDto;


import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);
    void deleteUser(Integer userId);
    List<UserDto> getAllUsers();

}
