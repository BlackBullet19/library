package org.telran.library.repository;

import org.telran.library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private List<Book> bookList;

    @Override
    public void init() {
        bookList = new ArrayList<>();
        bookList.add(new Book("BookOne", "AuthorOne", 100, 1));
        bookList.add(new Book("BookTwo", "AuthorTwo", 200, 2));
        bookList.add(new Book("BookThree", "AuthorThree", 300, 3));
        bookList.add(new Book("BookFour", "AuthorFour", 400, 4));
        bookList.add(new Book("BookFive", "AuthorFive", 500, 5));
    }

    @Override
    public List<Book> getBookRepository() {
        return bookList;
    }

    @Override
    public void addBook(Book book) {
        bookList.add(book);
    }

    @Override
    public void removeBook(int id) {
        bookList.remove(getBook(id));
    }

    @Override
    public Book getBook(int id) {
        Book book = bookList.stream().filter(el -> el.getId() == id).findFirst().get();
        return book;
    }
}
