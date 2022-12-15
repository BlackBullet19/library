package org.telran.library.controller;

import org.telran.library.model.Book;
import org.telran.library.service.*;

import java.util.List;

public class LibraryControllerImpl implements LibraryController {


    private BookService bookService;
    private OrderService orderService;

    public LibraryControllerImpl(BookService bookService, OrderService orderService) {
        this.bookService = bookService;
        this.orderService = orderService;
    }

    @Override
    public List<Book> getBookRepository() {
        return bookService.getBookRepositoryList();
    }

    @Override
    public List<Book> getUserBookList() {
        return orderService.getHomeRepositoryList();
    }

    @Override
    public void moveBookFromLibraryToUser(int bookId) {
        orderService.addBookToUserRepository(bookService.getBook(bookId));
        bookService.removeBookFromRepository(bookId);
    }

    @Override
    public void moveBookFromUserToLibrary(int bookId) {
        bookService.addBookToRepository(orderService.getBook(bookId));
        orderService.removeBookFromUserRepository(bookId);
    }
}
