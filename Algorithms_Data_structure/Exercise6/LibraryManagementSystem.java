import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// Define the Book class to represent a book in the library
class Book {
    String bookId;
    String title;
    String author;

    // Constructor to initialize a book
    Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

// Define the LibraryManager class to handle book searches
public class LibraryManagementSystem {
    // Linear Search to find a book by title
    static Book linearSearch(List<Book> books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search to find a book by title (requires sorted list by title)
    static Book binarySearch(List<Book> books, String title) {
        int low = 0;
        int high = books.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books.get(mid).title.compareToIgnoreCase(title);

            if (cmp == 0) {
                return books.get(mid);
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Create a list of books
        List<Book> books = new ArrayList<>(Arrays.asList(
            new Book("1", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("2", "To Kill a Mockingbird", "Harper Lee"),
            new Book("3", "1984", "George Orwell"),
            new Book("4", "The Catcher in the Rye", "J.D. Salinger")
        ));

        // Display all books
        System.out.println("All Books:");
        for (Book book : books) {
            System.out.println(book);
        }

        // Sort books by title for binary search
        books.sort((a, b) -> a.title.compareToIgnoreCase(b.title));

        // Search for books
        String searchTitle = "1984";

        // Linear search
        Book foundBook = linearSearch(books, searchTitle);
        System.out.println("\nLinear Search Result:");
        if (foundBook != null) {
            System.out.println(foundBook);
        } else {
            System.out.println("Book not found");
        }

        // Binary search
        foundBook = binarySearch(books, searchTitle);
        System.out.println("\nBinary Search Result:");
        if (foundBook != null) {
            System.out.println(foundBook);
        } else {
            System.out.println("Book not found");
        }
    }
}
