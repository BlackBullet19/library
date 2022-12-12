package org.telran.library.service;

import org.telran.library.model.User;

public interface UserService {

    User getUser(int id);

    void init();
}
