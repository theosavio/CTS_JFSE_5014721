import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(2, "1984", "George Orwell"));
        books.add(new Book(3, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(4, "Moby Dick", "Herman Melville"));

        Library library = new Library(books);

        // Linear Search
        System.out.println("Linear Search:");
        Book book = library.linearSearchByTitle("1984");
        if (book != null) {
            System.out.println("Found: " + book);
        } else {
            System.out.println("Book not found.");
        }

        // Sort and Binary Search
        library.sortBooksByTitle();
        System.out.println("\nBinary Search:");
        book = library.binarySearchByTitle("To Kill a Mockingbird");
        if (book != null) {
            System.out.println("Found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }
}
