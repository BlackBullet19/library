package org.telran.library.service;

import org.telran.library.model.Book;
import org.telran.library.model.User;
import org.telran.library.repository.HomeRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private HomeRepository homeRepository;


    public OrderServiceImpl(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    @Override
    public List<Book> getHomeRepositoryList(User user) {
        return homeRepository.getHomeRepository(user);
    }

    @Override
    public void addBookToUserRepository(Book book, User user) {
        homeRepository.addBook(book, user);
    }

    @Override
    public void removeBookFromUserRepository(int id, User user) {
        homeRepository.removeBook(id, user);
    }

    @Override
    public Book getBook(int id, User user) {
        return homeRepository.getBook(id, user);
    }

    @Override
    public void addUsers(List<User> userList) {
        homeRepository.addUsers(userList);
    }
}
