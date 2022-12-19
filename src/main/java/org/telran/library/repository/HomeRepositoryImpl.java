package org.telran.library.repository;

import org.telran.library.model.Book;
import org.telran.library.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeRepositoryImpl implements HomeRepository {

    private Map<User,List<Book>> userBookListMap;

    public HomeRepositoryImpl() {
        userBookListMap = new HashMap<>();
    }

    @Override
    public List<Book> getHomeRepository(User user) {
        return userBookListMap.get(user);
    }

    @Override
    public void addBook(Book book, User user) {
        getHomeRepository(user).add(book);
    }

    @Override
    public void removeBook(int bookId, User user) {
        getHomeRepository(user).remove(getBook(bookId, user));
    }

    @Override
    public Book getBook(int bookId, User user) {
        Book book = getHomeRepository(user).stream().filter(id -> id.getId() == bookId).findFirst().get();
        return book;
    }

    @Override
    public void addUsers(List<User> userList) {
        userList.forEach(user -> userBookListMap.put(user, new ArrayList<>()));
    }
}
