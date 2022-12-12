package org.telran.library;

import org.telran.library.controller.LibraryController;
import org.telran.library.controller.LibraryControllerImpl;

import java.util.Scanner;

public class AppLibrary {

    public static void main(String[] args) {

        LibraryController controller = new LibraryControllerImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your ID");
        controller.init(scanner.nextInt());

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
