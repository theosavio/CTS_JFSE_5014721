import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.BookstoreAPI.dto.BookDTO;
import com.onlinebookstore.BookstoreAPI.entity.Book;
import com.onlinebookstore.BookstoreAPI.exception.BookNotFoundException;
import com.onlinebookstore.BookstoreAPI.mapper.BookMapper;
import com.onlinebookstore.BookstoreAPI.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    // Method to get all books
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(bookMapper::toBookDTO)
                .collect(Collectors.toList());
    }

    // Method to get a book by ID
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return bookMapper.toBookDTO(book);
    }

    // Existing methods
    public BookDTO getBookDTO(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        return bookMapper.toBookDTO(book);
    }

    public Book saveBook(BookDTO bookDTO) {
        Book book = bookMapper.toBook(bookDTO);
        return bookRepository.save(book);
    }
}
