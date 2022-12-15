package org.telran.library.model;

import org.telran.library.repository.HomeRepository;

public class User {

    private int userId;

    private String username;

    private HomeRepository homeRepository;


    public User(int userId, String username, HomeRepository homeRepository) {
        this.userId = userId;
        this.username = username;
        this.homeRepository= homeRepository;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public HomeRepository getUserRepository() {
        return homeRepository;
    }
}
