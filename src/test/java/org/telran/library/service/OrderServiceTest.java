package org.telran.library.service;

import org.junit.jupiter.api.BeforeEach;
import org.telran.library.model.Book;
import org.telran.library.model.User;
import org.telran.library.repository.HomeRepository;
import org.telran.library.repository.HomeRepositoryImpl;
import org.telran.library.repository.UserRepository;
import org.telran.library.repository.UserRepositoryImpl;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderServiceTest {

    private HomeRepository homeRepository;
    private OrderService orderService;
    private Book book;
    private User user;
    UserRepository userRepository;
    UserService userService;

    @BeforeEach
    void init(){
        homeRepository = new HomeRepositoryImpl();
        orderService = new OrderServiceImpl(homeRepository);
        book = new Book("TestOne", "TestTwo", 1234, 1010);
        user = new User(1, "TestUser");
        userRepository = new UserRepositoryImpl();
        userService = new UserServiceImpl(userRepository);
        orderService.addUsers(userService.getUserList());
    }

    @org.junit.jupiter.api.Test
    void getHomeRepositoryList() {

        orderService.addBookToUserRepository(book,user);
        List<Book> homeRepositoryList = this.orderService.getHomeRepositoryList(user);
        homeRepositoryList.get(0);
        assertEquals(1010, homeRepositoryList.get(0).getId());
        assertEquals(1234, homeRepositoryList.get(0).getPageCount());
    }

    @org.junit.jupiter.api.Test
    void addBookToUserRepository() {
        orderService.addBookToUserRepository(book, user);
        Book book = orderService.getBook(1010, user);
        assertEquals(1234, book.getPageCount());
        assertEquals("TestOne", book.getName());
    }

    @org.junit.jupiter.api.Test
    void removeBookFromUserRepository() {
        orderService.addBookToUserRepository(book, user);
        orderService.removeBookFromUserRepository(1010, user);
        assertThrows(NoSuchElementException.class, () -> orderService.getBook(1010, user));
    }

    @org.junit.jupiter.api.Test
    void getBook() {
        orderService.addBookToUserRepository(book, user);
        List<Book> homeRepositoryList = this.orderService.getHomeRepositoryList(user);
        assertEquals(homeRepositoryList.get(0), orderService.getBook(1010, user));
    }
}
