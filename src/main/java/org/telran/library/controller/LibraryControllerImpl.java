package org.telran.library.controller;

import org.telran.library.model.Book;
import org.telran.library.model.User;
import org.telran.library.service.*;

import java.util.ArrayList;
import java.util.List;

public class LibraryControllerImpl implements LibraryController {


    private BookService bookService;
    private UserService userService;
    private OrderService orderService;


    @Override
    public void init(int id) {
        bookService = new BookServiceImpl();
        bookService.init();
        userService = new UserServiceImpl();
        userService.init();
        User user = userService.getUser(id);
        orderService = user.getOrderService();
        orderService.init();
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
