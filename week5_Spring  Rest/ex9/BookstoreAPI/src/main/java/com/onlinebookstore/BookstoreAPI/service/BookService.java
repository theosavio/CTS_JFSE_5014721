import org.springframework.beans.factory.annotation.Autowired;

import com.onlinebookstore.BookstoreAPI.dto.BookDTO;
import com.onlinebookstore.BookstoreAPI.entity.Book;
import com.onlinebookstore.BookstoreAPI.mapper.BookMapper;
import com.onlinebookstore.BookstoreAPI.repository.BookRepository;


public class BookService {

	 @Autowired
	    private BookRepository bookRepository;
    public BookDTO getBookDTO(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        return BookMapper.INSTANCE.toBookDTO(book);
    }

    public Book saveBook(BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.toBook(bookDTO);
        return bookRepository.save(book);
    }
}
