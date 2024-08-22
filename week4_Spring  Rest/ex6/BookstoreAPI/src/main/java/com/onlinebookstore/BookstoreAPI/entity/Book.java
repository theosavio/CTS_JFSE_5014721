package com.onlinebookstore.BookstoreAPI.entity;
import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter

@Entity
@Table(name="product")


public class Book {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String isbn;
    
}
