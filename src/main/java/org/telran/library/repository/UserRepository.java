package org.telran.library.repository;

import org.telran.library.model.User;

public interface UserRepository {

    User getUser(int id);

    void init();
}
