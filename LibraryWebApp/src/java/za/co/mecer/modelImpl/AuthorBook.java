package za.co.mecer.modelImpl;

import java.sql.SQLException;
import za.co.mecer.model.AuthorBooks;
import static za.co.mecer.model.Authors.AUTHOR_ID_ERROR_MSG;
import static za.co.mecer.model.Books.BOOK_ID_ERROR_MSG;
import za.co.mecer.dao.AuthorBookDAO;
import za.co.mecer.dao.AuthorDAO;
import za.co.mecer.dao.BookDAO;
import za.co.mecer.dao.impl.AuthorBookDAOImpl;
import za.co.mecer.dao.impl.AuthorDAOImpl;
import za.co.mecer.dao.impl.BookDAOImpl;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.exceptions.BookException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AuthorBook implements AuthorBooks {

    private int authorId, bookId;

    private BookDAO bookDao;
    private AuthorBookDAO authorBook;
    private AuthorDAO authorDao;
    private Author author;
    private Book book;

    /**
     *
     * @throws SQLException
     */
    public AuthorBook() throws SQLException {
        bookDao = new BookDAOImpl();
        authorBook = new AuthorBookDAOImpl();
        authorDao = new AuthorDAOImpl();
    }

    public AuthorBook(Author author, Book book) {
        this.author = author;
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public Book getBook() {
        return book;
    }

    /**
     *
     * @param authorId
     * @param bookId
     * @throws AuthorException
     * @throws SQLException
     */
    public AuthorBook(int authorId, int bookId) throws AuthorException, SQLException, BookException {
        this.setBookId(bookId);
        this.setAuthorId(authorId);
        bookDao = new BookDAOImpl();
        authorBook = new AuthorBookDAOImpl();
        authorDao = new AuthorDAOImpl();
    }

    /**
     *
     * @return
     */
    @Override
    public int getBookId() {
        return bookId;
    }

    /**
     *
     * @param bookId
     * @throws za.co.mecer.exceptions.BookException
     */
    @Override
    public void setBookId(int bookId) throws BookException {
        if (bookId <= 0) {
            throw new BookException(BOOK_ID_ERROR_MSG);
        }
        this.bookId = bookId;
    }

    /**
     *
     * @return
     */
    @Override
    public int getAuthorId() {
        return authorId;
    }

    /**
     *
     * @param authorId
     * @throws za.co.mecer.exceptions.AuthorException
     */
    @Override
    public void setAuthorId(int authorId) throws AuthorException {
        if (authorId <= 0) {
            throw new AuthorException(AUTHOR_ID_ERROR_MSG);
        }
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%n", authorDao.searchAuthor(authorDao.getAuthorName(authorId)),
                bookDao.searchBookByISBN(authorBook.getBookIsbn(bookId)));
    }

}
