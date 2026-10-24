
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    // Find a book using its ID
    private Book findBook(int id) {
        for (Book book : books) {
            if (book.getBookId() == id) {
                return book;
            }
        }
        return null;
    }

    // Add a new book
    public void addBook(int id, String title, String author) {
        if (id <= 0) {
            System.out.println("Book ID must be positive.");
            return;
        }

        if (title == null || title.isBlank()
                || author == null || author.isBlank()) {
            System.out.println("Title and author cannot be empty.");
            return;
        }

        if (findBook(id) != null) {
            System.out.println("Book ID already exists!");
            return;
        }

        books.add(new Book(id, title.trim(), author.trim()));
        System.out.println("Book added successfully!");
    }

    // Display all books
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            book.displayBook();
        }

        System.out.println("Total books: " + books.size());
    }

    // Search book
    public void searchBook(int id) {
        Book book = findBook(id);

        if (book == null) {
            System.out.println("Book not found!");
        } else {
            book.displayBook();
        }
    }

    // Delete book
    public void deleteBook(int id) {
        Book book = findBook(id);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Return the book before deleting it.");
            return;
        }

        books.remove(book);
        System.out.println("Book deleted successfully!");
    }

    // Update book details
    public void updateBook(int id, String title, String author) {
        Book book = findBook(id);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (title == null || title.isBlank()
                || author == null || author.isBlank()) {
            System.out.println("Title and author cannot be empty.");
            return;
        }

        book.setTitle(title.trim());
        book.setAuthor(author.trim());

        System.out.println("Book updated successfully!");
    }

    // Issue book
    public void issueBook(int id) {
        Book book = findBook(id);

        if (book == null) {
            System.out.println("Book not found!");
        } else if (book.isIssued()) {
            System.out.println("Book is already issued!");
        } else {
            book.setIssued(true);
            System.out.println("Book issued successfully!");
        }
    }

    // Return book
    public void returnBook(int id) {
        Book book = findBook(id);

        if (book == null) {
            System.out.println("Book not found!");
        } else if (!book.isIssued()) {
            System.out.println("This book is not currently issued.");
        } else {
            book.setIssued(false);
            System.out.println("Book returned successfully!");
        }
    }
}
