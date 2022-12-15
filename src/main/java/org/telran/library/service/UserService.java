package org.telran.library.service;

import org.telran.library.model.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    void saveUser(User user);

    User getUser(int id);

    void removeUser(int id);
}
