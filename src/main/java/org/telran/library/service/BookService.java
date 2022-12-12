package org.telran.library.service;

import org.telran.library.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getBookRepositoryList();

    void addBookToRepository(Book book);

    void removeBookFromRepository(int id);

    void init();

    Book getBook(int id);
}
