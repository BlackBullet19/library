package org.telran.library.service;

import org.telran.library.model.Book;
import org.telran.library.repository.BookRepository;
import org.telran.library.repository.BookRepositoryImpl;

import java.util.List;

public class BookServiceImpl implements BookService {

    BookRepository bookRepository = new BookRepositoryImpl();

    @Override
    public List<Book> getBookRepositoryList() {
        return bookRepository.getBookRepository();
    }

    @Override
    public void addBookToRepository(Book book) {
        bookRepository.addBook(book);
    }

    @Override
    public void removeBookFromRepository(int id) {
        bookRepository.removeBook(id);
    }

    @Override
    public void init() {
        bookRepository.init();
    }

    @Override
    public Book getBook(int id) {
        return bookRepository.getBook(id);
    }


}
