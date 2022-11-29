package za.co.mecer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import za.co.mecer.exceptions.BookException;
import za.co.mecer.modelImpl.Book;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface BookDAO {

    public String BOOK_ERROR_MSG = "Either Your Connection Or The Book Is Null!!";

    public int getBookId(String isbn);

    public void addBook(Book book);

    public List<Book> getAllBooks();

    public void removeBook(String isbn);

    public void changeBookAvailability(String isbn, boolean availability);

    public void changeBookAccessiblity(String isbn, boolean access);

    public Book searchBookByISBN(String ISBN);

    public Book searchBookByTitle(String title);

    public void searchAvailableBooks();

    public void searchAccessibleBooks();

    public void displayBooks() throws BookException;

    public Book searchBookById(int bookId);

}
