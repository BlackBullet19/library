package org.telran.library.repository;

import org.telran.library.model.Book;

import java.util.List;

public interface BookRepository {

    void init();

    List<Book> getBookRepository();

    void addBook(Book book);

    void removeBook(int id);

    Book getBook(int id);
}
