package org.telran.library.repository;

import org.telran.library.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getUserList();

    void saveUser(User user);

    User getUser(int id);

    void removeUser(int id);

}
