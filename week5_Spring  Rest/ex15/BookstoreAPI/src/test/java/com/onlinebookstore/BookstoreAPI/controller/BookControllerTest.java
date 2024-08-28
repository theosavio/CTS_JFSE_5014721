package com.onlinebookstore.BookstoreAPI.controller;

import com.onlinebookstore.BookstoreAPI.dto.BookDTO;
import com.onlinebookstore.BookstoreAPI.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllBooks() throws Exception {
        BookDTO book1 = new BookDTO(1L, "Book Title 1", "Author 1", 9.99, "ISBN123");
        BookDTO book2 = new BookDTO(2L, "Book Title 2", "Author 2", 19.99, "ISBN456");
        List<BookDTO> books = Arrays.asList(book1, book2);

        when(bookService.getAllBooks()).thenReturn(books);

        mockMvc.perform(get("/books")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"title\":\"Book Title 1\",\"author\":\"Author 1\",\"price\":9.99,\"isbn\":\"ISBN123\"}," +
                        "{\"id\":2,\"title\":\"Book Title 2\",\"author\":\"Author 2\",\"price\":19.99,\"isbn\":\"ISBN456\"}]"));
    }
    
    @Test
    public void testGetBookById() throws Exception {
        BookDTO book = new BookDTO(1L, "Book Title", "Author", 9.99, "ISBN123");
        when(bookService.getBookById(1L)).thenReturn(book);

        mockMvc.perform(get("/books/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"title\":\"Book Title\",\"author\":\"Author\",\"price\":9.99,\"isbn\":\"ISBN123\"}"));
    }
}
