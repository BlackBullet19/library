package org.telran.library.repository;

import org.telran.library.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private List<User> userList = new ArrayList<>();

    public UserRepositoryImpl() {
        userList.add(new User(1, "UserOne"));
        userList.add(new User(2, "UserTwo"));
    }

    @Override
    public List<User> getUserList() {
        return userList;
    }

    @Override
    public void saveUser(User user) {
        userList.add(user);
    }

    @Override
    public User getUser(int id) {
        return userList.stream().filter(userId -> userId.getUserId() == id).findFirst().get();
    }

    @Override
    public void removeUser(int id) {
        userList.remove(getUser(id));
    }
}
