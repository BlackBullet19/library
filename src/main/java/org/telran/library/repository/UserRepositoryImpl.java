package org.telran.library.repository;

import org.telran.library.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

   private List<User> userList;

    @Override
    public User getUser(int id) {
        return userList.stream().filter(user -> user.getUserId() == id).findFirst().get();
    }

    @Override
    public void init() {
        userList = new ArrayList<>();
        userList.add(new User(1,"UserOne"));
        userList.add(new User(2,"UserTwo"));
        userList.add(new User(3,"UserThree"));
    }
}
