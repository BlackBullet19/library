package org.telran.library.service;

import org.telran.library.model.User;
import org.telran.library.repository.UserRepository;
import org.telran.library.repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public User getUser(int id) {
        return userRepository.getUser(id);
    }

    @Override
    public void init() {
        userRepository.init();
    }
}
