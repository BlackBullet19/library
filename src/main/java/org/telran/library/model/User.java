package org.telran.library.model;

import org.telran.library.service.OrderService;
import org.telran.library.service.OrderServiceImpl;

import java.util.List;

public class User {

    private int userId;

    private String username;

    private List<Book> userHomeRepository;

    private OrderService orderService = new OrderServiceImpl();

    public User(int userId, String username) {
        this.userId = userId;
        this.username = username;
        this.userHomeRepository = orderService.getHomeRepositoryList();
    }

    public int getUserId() {
        return userId;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public String getUsername() {
        return username;
    }
}
