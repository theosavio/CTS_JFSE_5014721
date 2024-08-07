package com.library.service;

import org.springframework.stereotype.Service;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void manageBooks() {
        bookRepository.manage();
        System.out.println("Managing books...");
    }
}
