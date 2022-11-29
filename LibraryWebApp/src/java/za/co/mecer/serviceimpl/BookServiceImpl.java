package za.co.mecer.serviceimpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import za.co.mecer.dao.impl.BookDAOImpl;
import za.co.mecer.modelImpl.Book;
import za.co.mecer.services.BookService;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BookServiceImpl implements BookService {

    BookDAOImpl bookImpl;
    Scanner input = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public BookServiceImpl() throws SQLException {
        this.bookImpl = new BookDAOImpl();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookImpl.getAllBooks();
    }

    @Override
    public void addBook(Book book) {
        bookImpl.addBook(book);
    }

    @Override
    public Book getBookByISBN(String ISBN) {
        return bookImpl.searchBookByISBN(ISBN);
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookImpl.searchBookByTitle(title);
    }
}
