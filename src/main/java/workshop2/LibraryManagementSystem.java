package workshop2;

import java.util.HashSet;

public class LibraryManagementSystem {
    private final HashSet<Book> books;
    private final HashSet<Book> borrowedBooks;

    public LibraryManagementSystem() {
        books = new HashSet<>();
        borrowedBooks = new HashSet<>();


    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void borrowBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
            borrowedBooks.add(book);
        } else {
            System.out.println("Book not found in the library");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            books.add(book);
            System.out.printf("Book %s returned successfully!", book);
        } else {
            System.out.printf("Book %s not borrowed", book);
        }
    }

    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed");
        } else {
            for (Book book : borrowedBooks) {
                System.out.println(book);
            }
        }
    }

    public void displayAvailableBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        // Creating a library management system
        LibraryManagementSystem library = new LibraryManagementSystem();

        // Create sample books
        Book book1 = new Book("The Alchemist", "Paulo Coelho", 1988);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);

        // Adding books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Displaying all the books in the library
        System.out.println("All books in the library:");
        library.displayBooks();

        // Borrowing a book
        library.borrowBook(book1);

        // Displaying borrowed books
        System.out.println("\nBorrowed books:");
        library.displayBorrowedBooks();

        // Displaying available books
        System.out.println("\nAvailable books:");
        library.displayAvailableBooks();

        // Returning a book
        System.out.println("\nReturning a borrowed book:");
        library.returnBook(book1);

        // Displaying borrowed books
        System.out.println("\nBorrowed books:");
        library.displayBorrowedBooks();

        // Remove books from the library
        library.removeBook(book1);

        // Displaying all the books in the library
        System.out.println("\nAll books in the library:");
        library.displayBooks();
    }
}
