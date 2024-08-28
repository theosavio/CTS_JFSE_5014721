package com.onlinebookstore.BookstoreAPI.controller;

import com.onlinebookstore.BookstoreAPI.entity.Book;
import com.onlinebookstore.BookstoreAPI.exception.BookNotFoundException;
import com.onlinebookstore.BookstoreAPI.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Operation(summary = "Create a new book")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Book created",
                     content = { @Content(mediaType = "application/json",
                     schema = @Schema(implementation = Book.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid input",
                     content = @Content) })
    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @Operation(summary = "Get all books")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the books",
                     content = { @Content(mediaType = "application/json",
                     schema = @Schema(implementation = Book.class)) }),
        @ApiResponse(responseCode = "404", description = "Books not found",
                     content = @Content) })
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return ResponseEntity.ok(books);
    }

    @Operation(summary = "Get a book by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the book",
                     content = { @Content(mediaType = "application/json",
                     schema = @Schema(implementation = Book.class)) }),
        @ApiResponse(responseCode = "404", description = "Book not found",
                     content = @Content) })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EntityModel<Book> getBookById(@PathVariable Long id) {
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new BookNotFoundException(id));
        
        return EntityModel.of(book,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("books"));
    }

    @Operation(summary = "Update a book by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Book updated",
                     content = { @Content(mediaType = "application/json",
                     schema = @Schema(implementation = Book.class)) }),
        @ApiResponse(responseCode = "404", description = "Book not found",
                     content = @Content) })
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPrice(bookDetails.getPrice());
            book.setIsbn(bookDetails.getIsbn());
            Book updatedBook = bookRepository.save(book);
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Delete a book by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Book deleted",
                     content = @Content),
        @ApiResponse(responseCode = "404", description = "Book not found",
                     content = @Content) })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            bookRepository.delete(existingBook.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Filter books by title and/or author")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Filtered books found",
                     content = { @Content(mediaType = "application/json",
                     schema = @Schema(implementation = Book.class)) }) })
    @GetMapping("/filter")
    public ResponseEntity<List<Book>> getBooksByFilter(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author) {

        List<Book> books;
        if (title != null && author != null) {
            books = bookRepository.findByTitleAndAuthor(title, author);
        } else if (title != null) {
            books = bookRepository.findByTitle(title);
        } else if (author != null) {
            books = bookRepository.findByAuthor(author);
        } else {
            books = bookRepository.findAll();
        }

        return ResponseEntity.ok(books);
    }
}
