package com.onlinebookstore.BookstoreAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.onlinebookstore.BookstoreAPI.entity.Book;

import java.util.*;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
	
	List<Book> findByTitleAndAuthor(String title,String author);
	
	
	
}
