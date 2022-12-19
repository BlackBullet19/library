package org.telran.library;

import org.telran.library.controller.LibraryController;
import org.telran.library.controller.LibraryControllerImpl;
import org.telran.library.model.User;
import org.telran.library.repository.*;
import org.telran.library.service.*;
import java.util.Scanner;

public class AppLibrary {

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserServiceImpl(userRepository);

        BookRepository bookRepository = new BookRepositoryImpl();
        BookService bookService = new BookServiceImpl(bookRepository);

        HomeRepository homeRepository = new HomeRepositoryImpl();
        OrderService orderService = new OrderServiceImpl(homeRepository);

        orderService.addUsers(userService.getUserList());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your ID");
        int userId = scanner.nextInt();
        User currentUser = userService.getUser(userId);

        LibraryController controller = new LibraryControllerImpl(bookService, orderService, currentUser);

        boolean exitKeyWord = false;

        while (!exitKeyWord) {

            String action = scanner.nextLine();
            System.out.println("What would you like to do?");
            System.out.println("Write 'take' if you want to take a book");
            System.out.println("Write 'return' if you want to return a book");
            System.out.println("Write 'exit' if you want to exit");
            System.out.println("Books in library : " + controller.getBookRepository());
            System.out.println("Your books : " + controller.getUserBookList());
            if ("take".equals(action)) {
                System.out.println("Write bookId");
                controller.moveBookFromLibraryToUser(scanner.nextInt());
            }
            if ("return".equals(action)) {
                System.out.println("Write bookId");
                controller.moveBookFromUserToLibrary(scanner.nextInt());
            }
            if ("exit".equals(action)) {
                scanner.close();
                exitKeyWord = true;
            }
        }
    }
}
