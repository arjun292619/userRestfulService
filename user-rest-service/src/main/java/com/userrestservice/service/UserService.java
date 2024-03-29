package com.userrestservice.service;

import com.userrestservice.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(long userId);

    List<User> getAllUsers();

    User updateUser(Long userId, User user);
}
