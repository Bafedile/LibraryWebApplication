package za.co.mecer.modelImpl;

import za.co.mecer.model.Books;
import za.co.mecer.exceptions.BookException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Book implements Books {

    private String ISBN, title;
    private boolean availability, access;
    private int bookId;

    /**
     *
     * @param bookId
     * @param title
     * @param ISBN
     * @param availability
     * @param access
     */
    public Book(int bookId, String title, String ISBN, boolean availability, boolean access) throws BookException {
        this.title = title;
        this.ISBN = ISBN;
        this.availability = availability;
        this.access = access;
        this.setBookId(bookId);

    }

    /**
     *
     * @param title
     * @param ISBN
     * @param availability
     * @param access
     */
    public Book(String title, String ISBN, boolean availability, boolean access) throws BookException {
        this.title = title;
        this.setISBN(ISBN);
        this.availability = availability;
        this.access = access;

    }

    /**
     *
     * @param ISBN
     * @throws za.co.mecer.exceptions.BookException
     */
    @Override
    public void setISBN(String ISBN) throws BookException {
        if (!checkISBN(ISBN)) {
            throw new BookException(BOOK_ISBN_ERROR_MSG);
        }
        this.ISBN = ISBN;
    }

    /**
     *
     * @param availability
     */
    @Override
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    /**
     *
     * @param access
     */
    @Override
    public void setAccess(boolean access) {
        this.access = access;
    }

    /**
     *
     * @param title
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    @Override
    public String getISBN() {
        return ISBN;
    }

    /**
     *
     * @return
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean getAccess() {
        return access;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean getAvailability() {
        return availability;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Book title: %S%n"
                + "Book ISBN Number: %s%n"
                + "Book Availability: %s%n"
                + "Book Accessibility: %s%n", title, ISBN, availability, access);
    }

    /**
     * @return the bookId
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * @param bookId the bookId to set
     */
    public void setBookId(int bookId) throws BookException {
        if (bookId <= 0) {
            throw new BookException(BOOK_ID_ERROR_MSG);
        }
        this.bookId = bookId;
    }

    public boolean checkISBN(String isbn) {
        return isbn.length() == 13;
    }

}
