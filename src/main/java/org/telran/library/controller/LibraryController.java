package org.telran.library.controller;

import org.telran.library.model.Book;

import java.util.List;

public interface LibraryController {

    List<Book> getBookRepository();

    List<Book> getUserBookList();

    void moveBookFromLibraryToUser( int bookId);

    void moveBookFromUserToLibrary(int bookId);
}
