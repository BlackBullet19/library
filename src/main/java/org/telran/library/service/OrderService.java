package org.telran.library.service;

import org.telran.library.model.Book;
import org.telran.library.model.User;

import java.util.List;

public interface OrderService {

    List<Book> getHomeRepositoryList(User user);

    void addBookToUserRepository(Book book, User user);

    void removeBookFromUserRepository(int id, User user);

    Book getBook(int id, User user);

    void addUsers(List<User> userList);
}
