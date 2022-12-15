package org.telran.library.service;

import org.telran.library.model.User;
import org.telran.library.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUserList() {
        return userRepository.getUserList();
    }

    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    @Override
    public User getUser(int userId) {
        return userRepository.getUser(userId);
    }

    @Override
    public void removeUser(int userId) {
        userRepository.removeUser(userId);
    }
}
