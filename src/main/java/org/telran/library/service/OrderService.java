package org.telran.library.service;

import org.telran.library.model.Book;

import java.util.List;

public interface OrderService {

    List<Book> getHomeRepositoryList();

    void addBookToUserRepository(Book book);

    void removeBookFromUserRepository(int id);

    void init();

    Book getBook(int id);
}
