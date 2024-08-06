package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Setter for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void manageBooks() {
        // Make sure bookRepository is not null
        if (bookRepository != null) {
            bookRepository.manage();
        } else {
            System.out.println("BookRepository is not initialized!");
        }
    }
}
