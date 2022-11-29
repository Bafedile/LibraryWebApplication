package za.co.mecer.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import za.co.mecer.exceptions.BookException;
import za.co.mecer.modelImpl.Book;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface BookService {

    public List<Book> getAllBooks();

    public void addBook(Book book);

    public Book getBookByISBN(String ISBN);

    public Book getBookByTitle(String title);

}
