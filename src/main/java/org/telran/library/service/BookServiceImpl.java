package org.telran.library.service;

import org.telran.library.model.Book;
import org.telran.library.repository.BookRepository;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

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
    public Book getBook(int id) {
        return bookRepository.getBook(id);
    }


}
