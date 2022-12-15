package org.telran.library.service;

import org.telran.library.model.Book;
import org.telran.library.repository.HomeRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private HomeRepository homeRepository;


    public OrderServiceImpl(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    @Override
    public List<Book> getHomeRepositoryList() {
        return homeRepository.getHomeRepository();
    }

    @Override
    public void addBookToUserRepository(Book book) {
        homeRepository.addBook(book);
    }

    @Override
    public void removeBookFromUserRepository(int id) {
        homeRepository.removeBook(id);
    }

    @Override
    public Book getBook(int id) {
        return homeRepository.getBook(id);
    }
}
