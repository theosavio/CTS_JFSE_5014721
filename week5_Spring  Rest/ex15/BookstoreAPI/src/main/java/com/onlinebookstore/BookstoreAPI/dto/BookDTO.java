package com.onlinebookstore.BookstoreAPI.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Details about the book")
public class BookDTO {
    
    @Schema(description = "Unique identifier of the book", example = "1")
    private Long id;

    @Schema(description = "Title of the book", example = "Spring in Action")
    private String title;

    @Schema(description = "Author of the book", example = "Craig Walls")
    private String author;

    @Schema(description = "Price of the book", example = "29.99")
    private double price;

    @Schema(description = "ISBN number", example = "978-1617294945")
    private String isbn;

    // Default constructor
    public BookDTO() {}

    // Parameterized constructor
    public BookDTO(Long id, String title, String author, double price, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    // Getters and Setters
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

    // Override equals() and hashCode() for proper comparisons
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookDTO bookDTO = (BookDTO) o;

        if (Double.compare(bookDTO.price, price) != 0) return false;
        if (!id.equals(bookDTO.id)) return false;
        if (!title.equals(bookDTO.title)) return false;
        if (!author.equals(bookDTO.author)) return false;
        return isbn.equals(bookDTO.isbn);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + author.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + isbn.hashCode();
        return result;
    }

    // Override toString() for a string representation
    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
