package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private BookRepository anotherBookRepository;

    // Constructor Injection
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Setter Injection
    public void setAnotherBookRepository(BookRepository anotherBookRepository) {
        this.anotherBookRepository = anotherBookRepository;
    }

    public void manageBooks() {
        bookRepository.manage();
        System.out.println("Managing books...");
        if (anotherBookRepository != null) {
            anotherBookRepository.manage();
            System.out.println("Managing books with another repository...");
        }
    }
}
