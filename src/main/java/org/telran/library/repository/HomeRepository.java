package org.telran.library.repository;

import org.telran.library.model.Book;

import java.util.List;

public interface HomeRepository {

    void init();

    List<Book> getHomeRepository();

    void addBook(Book book);

    void removeBook(int id);

    Book getBook(int id);
}
