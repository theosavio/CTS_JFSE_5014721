package com.onlinebookstore.BookstoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)  
public class BookDTO {
    
    @JsonProperty("book_id") 
    private Long id;
    
    @JsonProperty("book_title")
    private String title;
    
    @JsonProperty("book_author")
    private String author;
    
    @JsonProperty("book_price")
    private double price;
    
    @JsonProperty("book_isbn")
    private String isbn;

    // Getters and Setters

    public BookDTO(long l, String string, String string2, double d, String string3) {
		
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
