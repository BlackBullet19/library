package org.telran.library.controller;

import org.telran.library.model.Book;
import org.telran.library.model.User;
import org.telran.library.service.*;

import java.util.List;

public class LibraryControllerImpl implements LibraryController {


    private BookService bookService;
    private OrderService orderService;
    private User user;

    public LibraryControllerImpl(BookService bookService, OrderService orderService, User user) {
        this.bookService = bookService;
        this.orderService = orderService;
        this.user = user;
    }

    @Override
    public List<Book> getBookRepository() {
        return bookService.getBookRepositoryList();
    }

    @Override
    public List<Book> getUserBookList() {
        return orderService.getHomeRepositoryList(user);
    }

    @Override
    public void moveBookFromLibraryToUser(int bookId) {
        orderService.addBookToUserRepository(bookService.getBook(bookId), user);
        bookService.removeBookFromRepository(bookId);
    }

    @Override
    public void moveBookFromUserToLibrary(int bookId) {
        bookService.addBookToRepository(orderService.getBook(bookId, user));
        orderService.removeBookFromUserRepository(bookId, user);
    }
}
