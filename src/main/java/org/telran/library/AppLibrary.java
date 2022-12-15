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

        User userOne = new User(1, "UserOne", new HomeRepositoryImpl());
        User userTwo = new User(2, "UserTwo", new HomeRepositoryImpl());

        userService.saveUser(userOne);
        userService.saveUser(userTwo);

        BookRepository bookRepository = new BookRepositoryImpl();
        BookService bookService = new BookServiceImpl(bookRepository);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your ID");
        int userId = scanner.nextInt();
        User currentUser = userService.getUser(userId);

        OrderService orderService = new OrderServiceImpl(currentUser.getUserRepository());

        LibraryController controller = new LibraryControllerImpl(bookService, orderService);

        boolean exitKeyWord = false;

        while (!exitKeyWord) {

            String action = scanner.nextLine();
            System.out.println("What would you like to do?");
            System.out.println("Write 'take' if you want to take a book");
            System.out.println("Write 'return' if you want to return a book");
            System.out.println("Write 'exit' if you want to exit");
            System.out.println("Books in library : " + controller.getBookRepository());
            System.out.println("Your books : " + controller.getUserBookList());
            if (action.equals("take")) {
                System.out.println("Write bookId");
                controller.moveBookFromLibraryToUser(scanner.nextInt());
            }
            if (action.equals("return")) {
                System.out.println("Write bookId");
                controller.moveBookFromUserToLibrary(scanner.nextInt());
            }
            if (action.equals("exit")) {
                scanner.close();
                exitKeyWord = true;
            }
        }
    }
}
