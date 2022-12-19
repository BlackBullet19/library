package org.telran.library.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.telran.library.model.User;
import org.telran.library.repository.UserRepository;
import org.telran.library.repository.UserRepositoryImpl;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserServiceTest {

    private UserRepository userRepository = new UserRepositoryImpl();
    private UserService userService = new UserServiceImpl(userRepository);
    private User user = new User(1, "TestUser");

    @BeforeEach
    void init() {
        userService.saveUser(user);
    }

    @Test
    void getUserList() {
        List<User> userList = userService.getUserList();
        assertEquals(user, userList.get(0));
    }

    @Test
    void saveUser() {
        List<User> userList = userService.getUserList();
        assertEquals(user, userList.get(0));
    }

    @Test
    void getUser() {
        assertEquals(user, userService.getUser(user.getUserId()));
    }

    @Test
    void removeUser() {
        userService.removeUser(user.getUserId());
        assertThrows(NoSuchElementException.class, () -> userService.getUser(user.getUserId()));
    }
}