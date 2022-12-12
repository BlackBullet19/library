package org.telran.library.repository;

import org.telran.library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class HomeRepositoryImpl implements HomeRepository {

    private List<Book> homeBookList;

    @Override
    public void init() {
        homeBookList = new ArrayList<>();
    }

    @Override
    public List<Book> getHomeRepository() {
        return homeBookList;
    }

    @Override
    public void addBook(Book book) {
        homeBookList.add(book);
    }

    @Override
    public void removeBook(int id) {
        homeBookList.remove(getBook(id));
    }

    @Override
    public Book getBook(int id) {
        Book book = homeBookList.stream().filter(el -> el.getId() == id).findFirst().get();
        return book;
    }
}
