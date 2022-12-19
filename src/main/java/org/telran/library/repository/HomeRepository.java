package org.telran.library.repository;

import org.telran.library.model.Book;
import org.telran.library.model.User;

import java.util.List;

public interface HomeRepository {

    List<Book> getHomeRepository(User user);

    void addBook(Book book, User user);

    void removeBook(int bookId, User user);

    Book getBook(int bookId, User user);

    void addUsers(List<User> userList);
}
