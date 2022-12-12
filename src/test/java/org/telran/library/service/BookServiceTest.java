package org.telran.library.service;


import org.junit.jupiter.api.BeforeEach;
import org.telran.library.model.Book;


import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class BookServiceTest {

   private BookService bookService = new BookServiceImpl();

    @BeforeEach
    void init(){
        bookService.init();
    }


    @org.junit.jupiter.api.Test
    void getBookRepositoryList() {
        List<Book> bookRepositoryList = this.bookService.getBookRepositoryList();
        assertEquals(1, bookRepositoryList.get(0).getId());
        assertEquals(100, bookRepositoryList.get(0).getPageCount());
    }

    @org.junit.jupiter.api.Test
    void addBookToRepository() {

        bookService.addBookToRepository(new Book("TestOne", "TestTwo", 1234, 1010));
        Book book = bookService.getBook(1010);
        assertEquals(1234, book.getPageCount());
        assertEquals("TestOne", book.getName());
    }

    @org.junit.jupiter.api.Test
    void removeBookFromRepository() {
        bookService.addBookToRepository(new Book("TestOne", "TestTwo", 1234, 1010));
        bookService.removeBookFromRepository(1010);
        assertThrows(NoSuchElementException.class, () -> bookService.getBook(1010));
    }

    @org.junit.jupiter.api.Test
    void getBook() {
        Book book = bookService.getBook(5);
        assertEquals(500, book.getPageCount());
    }
}
