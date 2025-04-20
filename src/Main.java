import java.util.Scanner;

public class Main {
    static Book[] books = new Book[20];

    public static void main(String[] args) {
        books[0] = new Book(111, "978-0307292063", "Foundation");
        books[1] = new Book(222, "ASIN-B07D23CFGR", "Atomic Habits");
        books[2] = new Book(333, "978-0679728757", "Blood Meridian");

        Scanner in = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nMAIN MENU:");
            System.out.println("1 - Show Available Books");
            System.out.println("2 - Show Checked Out Books");
            System.out.println("0 - Exit");
            System.out.print("Enter your choice: ");

            choice = in.nextInt();
            in.nextLine(); // Clear input buffer

            switch (choice) {
                case 1 -> showAvailableBooks(in);
                case 2 -> showCheckedOutBooks(in);
                case 0 -> {
                    System.out.println("Thanks for using the Library!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    static void showAvailableBooks(Scanner in) {
        System.out.println("\nAVAILABLE BOOKS:");
        for (Book b : books) {
            if (b != null && !b.isCheckedOut()) {
                System.out.printf("ID: %d - %s (%s)\n", b.getId(), b.getTitle(), b.getIsbn());
            }
        }

        while (true) {
            System.out.println("\nC - Check out a book | X - Exit to main menu");
            String command = in.nextLine().trim();

            if (command.equalsIgnoreCase("X")) {
                return;
            } else if (command.equalsIgnoreCase("C")) {
                System.out.print("Enter book ID to check out: ");
                int id = in.nextInt();
                in.nextLine(); // clear buffer

                Book book = findBookById(id);
                if (book != null && !book.isCheckedOut()) {
                    System.out.print("Enter your name: ");
                    String name = in.nextLine().trim();
                    book.checkOut(name);
                    System.out.println("Book checked out successfully.");
                } else {
                    System.out.println("Book not available or ID not found.");
                }
            } else {
                System.out.println("Unknown command.");
            }
        }
    }

    static void showCheckedOutBooks(Scanner in) {
        System.out.println("\nCHECKED OUT BOOKS:");
        for (Book b : books) {
            if (b != null && b.isCheckedOut()) {
                System.out.printf("ID: %d - %s (Checked out to: %s)\n", b.getId(), b.getTitle(), b.getCheckedOutTo());
            }
        }

        while (true) {
            System.out.println("\nC - Check in a book | X - Exit to main menu");
            String command = in.nextLine().trim();

            if (command.equalsIgnoreCase("X")) {
                return;
            } else if (command.equalsIgnoreCase("C")) {
                System.out.print("Enter book ID to check in: ");
                int id = in.nextInt();
                in.nextLine(); // clear buffer

                Book book = findBookById(id);
                if (book != null && book.isCheckedOut()) {
                    book.checkIn();
                    System.out.println("Book checked in successfully.");
                } else {
                    System.out.println("Invalid ID or book is not checked out.");
                }
            } else {
                System.out.println("Unknown command.");
            }
        }
    }

    static Book findBookById(int id) {
        for (Book b : books) {
            if (b != null && b.getId() == id) {
                return b;
            }
        }
        return null;
    }
}
