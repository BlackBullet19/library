package org.telran.library.service;

import org.junit.jupiter.api.BeforeEach;
import org.telran.library.model.Book;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderServiceTest {

    private OrderService orderService = new OrderServiceImpl();

    @BeforeEach
    void init() {
        orderService.init();
    }

    @org.junit.jupiter.api.Test
    void getHomeRepositoryList() {

        orderService.addBookToUserRepository(new Book("TestOne", "TestTwo", 1234, 1010));
        List<Book> homeRepositoryList = this.orderService.getHomeRepositoryList();
        homeRepositoryList.get(0);
        assertEquals(1010, homeRepositoryList.get(0).getId());
        assertEquals(1234, homeRepositoryList.get(0).getPageCount());
    }

    @org.junit.jupiter.api.Test
    void addBookToUserRepository() {
        orderService.addBookToUserRepository(new Book("TestOne", "TestTwo", 1234, 1010));
        Book book = orderService.getBook(1010);
        assertEquals(1234, book.getPageCount());
        assertEquals("TestOne", book.getName());
    }

    @org.junit.jupiter.api.Test
    void removeBookFromUserRepository() {
        orderService.addBookToUserRepository(new Book("TestOne", "TestTwo", 1234, 1010));
        orderService.removeBookFromUserRepository(1010);
        assertThrows(NoSuchElementException.class, () -> orderService.getBook(1010));
    }

    @org.junit.jupiter.api.Test
    void getBook() {
        orderService.addBookToUserRepository(new Book("TestOne", "TestTwo", 1234, 1010));
        List<Book> homeRepositoryList = this.orderService.getHomeRepositoryList();
        assertEquals(homeRepositoryList.get(0), orderService.getBook(1010));
    }
}