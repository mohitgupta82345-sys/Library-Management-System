
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Update Book");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter a valid number: ");
                sc.nextLine();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = readId(sc);

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    library.addBook(id, title, author);
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to search: ");
                    library.searchBook(readId(sc));
                    break;

                case 4:
                    System.out.print("Enter Book ID to delete: ");
                    library.deleteBook(readId(sc));
                    break;

                case 5:
                    System.out.print("Enter Book ID to update: ");
                    int updateId = readId(sc);

                    System.out.print("Enter new title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter new author: ");
                    String newAuthor = sc.nextLine();

                    library.updateBook(updateId, newTitle, newAuthor);
                    break;

                case 6:
                    System.out.print("Enter Book ID to issue: ");
                    library.issueBook(readId(sc));
                    break;

                case 7:
                    System.out.print("Enter Book ID to return: ");
                    library.returnBook(readId(sc));
                    break;

                case 8:
                    System.out.println(
                        "Thank you for using the Library System!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice! Select 1 to 8."
                    );
            }

        } while (choice != 8);

        sc.close();
    }

    private static int readId(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Enter a valid numeric ID: ");
            sc.nextLine();
        }

        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }
}
