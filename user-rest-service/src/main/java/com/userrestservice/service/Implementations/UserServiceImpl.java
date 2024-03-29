package com.userrestservice.service.Implementations;

import com.userrestservice.entity.User;
import com.userrestservice.repository.UserRepository;
import com.userrestservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User updateUser(Long userId, User user) {

        User matchedUser = userRepository.findById(userId).get();

        matchedUser.setFirstName(user.getFirstName());
        matchedUser.setLastName(user.getLastName());
        matchedUser.setEmail(user.getEmail());
        matchedUser.setPhone(user.getPhone());
        return userRepository.save(matchedUser);
    }
}
