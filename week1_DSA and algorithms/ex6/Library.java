import java.util.Collections;
import java.util.Comparator;

public class Library {
   
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);
            int comparison = midBook.getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return midBook;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Book not found
    }

   
    public void sortBooksByTitle() {
        Collections.sort(books, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
    }
}
