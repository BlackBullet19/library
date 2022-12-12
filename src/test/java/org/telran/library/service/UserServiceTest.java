package org.telran.library.service;

import org.junit.jupiter.api.BeforeEach;
import org.telran.library.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @BeforeEach
    void init() {
        userService.init();
    }

    @org.junit.jupiter.api.Test
    void getUser() {
        User user = userService.getUser(1);
        assertEquals("UserOne", user.getUsername());
    }
}