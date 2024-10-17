import java.util.Scanner;

class Book {
    int bookId;
    String title;
    final String author;
    int availableCopies;

    // Constructor
    Book(int bId, String bTitle, String auth, int avlCop) {
        bookId = bId;
        title = bTitle;
        availableCopies = avlCop;
        author = auth;
    }

    void borrowBook() {
        if (availableCopies == 0) {
            System.out.println("No copy available for: " + title);
        } else {
            availableCopies -= 1;
            System.out.println("No. of copies left for " + title + ": " + availableCopies);
        }
    }

    void display() {
        System.out.println("Book Id: " + bookId);
        System.out.println("Book Title: " + title);
        System.out.println("Book Author: " + author);
        System.out.println("Copies available: " + availableCopies);
    }
}

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        books[0] = new Book(100, "Alchemist", "Paulo Coelho", 21);
        books[1] = new Book(101, "Harry Potter 1", "JK Rowling", 10);
        books[2] = new Book(102, "Harry Potter 2", "JK Rowling", 34);
        books[3] = new Book(103, "Harry Potter 3", "JK Rowling", 30);
        books[4] = new Book(104, "Harry Potter 4", "JK Rowling", 26);
        
        Scanner scanner = new Scanner(System.in);
        int select;

        do {
            System.out.println("\nChoose function for Library:");
            System.out.println("1. Borrow a book");
            System.out.println("2. Display all books");
            System.out.println("3. Exit");
            select = scanner.nextInt();

            switch (select) {
                case 1:
                    System.out.println("Enter book ID:");
                    int bookId = scanner.nextInt();
                    boolean found = false;
                    for (Book book : books) {
                        if (bookId == book.bookId) {
                            book.borrowBook();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Book ID not found.");
                    }
                    break;

                case 2:
                    for (Book book : books) {
                        book.display();
                    }
                    break;

                case 3:
                    System.out.println("Exiting the library.");
                    break;

                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        } while (select != 3);
        
        scanner.close();
    }
}
