package za.co.mecer.serviceimpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import za.co.mecer.dao.BookDAO;
import za.co.mecer.dao.impl.AuthorBookDAOImpl;
import za.co.mecer.modelImpl.Author;
import za.co.mecer.dao.impl.AuthorDAOImpl;
import za.co.mecer.dao.impl.BookDAOImpl;
import za.co.mecer.modelImpl.AuthorBook;
import za.co.mecer.modelImpl.Book;
import za.co.mecer.services.AuthorService;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AuthorServiceImpl implements AuthorService {

    AuthorDAOImpl authorImpl;
    AuthorBookDAOImpl authorBookImpl;
    Scanner input = new Scanner(System.in);
    BookDAO bookImpl;
    String bookISBN;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Connection conn;

    /**
     *
     * @param conn
     * @throws SQLException
     */
    public AuthorServiceImpl() throws SQLException {
        this.authorImpl = new AuthorDAOImpl();
        this.authorBookImpl = new AuthorBookDAOImpl();
        this.bookImpl = new BookDAOImpl();
    }

    @Override
    public List<Author> getAuthors() {
        return authorImpl.getAllAuthors();
    }

    @Override
    public List<AuthorBook> getAuthorBooks() {
        return authorBookImpl.displayAuthorAndBook();
    }

    @Override
    public void addAuthorBook(AuthorBook authorBook) {
        Author author = authorImpl.searchAuthor(authorBook.getAuthor().getName());
        Book book = bookImpl.searchBookByISBN(authorBook.getBook().getISBN());
        authorBookImpl.addAuthorBook(author.getAuthorId(), book.getBookId());
    }

    @Override
    public void addAuthor(Author author) {
        authorImpl.addAuthor(author);
    }

    @Override
    public void addBook(Book book) {
        bookImpl.addBook(book);
    }
}
