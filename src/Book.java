/**
 * Represents a book in a library system.
 */
public class Book {
    private int id;                // Unique book ID
    private String isbn;          // ISBN of the book
    private String title;         // Title of the book
    private boolean isCheckedOut; // Status of the book (checked out or not)
    private String checkedOutTo;  // Name of the person who checked out the book

    /**
     * Constructs a Book object with the given ID, ISBN, and title.
     */
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    /**
     * Checks out the book to a person.
     */
    public void checkOut(String name) {
        this.checkedOutTo = name;
        this.isCheckedOut = true;
    }

    /**
     * Returns the book to the library.
     */
    public void checkIn() {
        this.checkedOutTo = "";
        this.isCheckedOut = false;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    // Setters (optional, based on design needs)
    public void setId(int id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
