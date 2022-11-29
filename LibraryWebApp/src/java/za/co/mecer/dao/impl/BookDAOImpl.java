package za.co.mecer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static za.co.mecer.model.Books.BOOK_NOT_FOUND_MSG;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.dao.BookDAO;
import za.co.mecer.dao.ClosingDAO;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.exceptions.BookException;
import za.co.mecer.modelImpl.Book;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BookDAOImpl implements BookDAO, ClosingDAO {

    private PreparedStatement preparedStatement = null;
    private Connection conn = null;
    private ResultSet result = null;
    private List<Book> books = new ArrayList<>();

    /**
     *
     * @param conn
     * @throws SQLException
     */
    public BookDAOImpl() throws SQLException {
        this.conn = DatabaseConnection.getInstance().getConnection();
    }

    /**
     *
     * @param book
     */
    @Override
    public void addBook(Book book) {
        /**
         * <<Book fields>> isbn, title,available, borrowable
         */
        try {
            if (conn != null && book != null) {
                preparedStatement = conn.prepareStatement("INSERT INTO book (isbn,title,available,borrowable) VALUES"
                        + "(?,?,?,?)");
                preparedStatement.setString(1, book.getISBN());
                preparedStatement.setString(2, book.getTitle());
                preparedStatement.setBoolean(3, true);
                preparedStatement.setBoolean(4, true);
                preparedStatement.executeUpdate();
            } else {
                throw new BookException(BOOK_ERROR_MSG);
            }
        } catch (SQLException | BookException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    /**
     *
     * @param isbn
     */
    @Override
    public void removeBook(String isbn) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("DELETE FROM book WHERE isbn=?");
                preparedStatement.setString(1, isbn);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    /**
     *
     * @param isbn
     * @param availability
     */
    @Override
    public void changeBookAvailability(String isbn, boolean availability) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE book SET available=? WHERE isbn =?");
                preparedStatement.setBoolean(1, availability);
                preparedStatement.setString(2, isbn);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    /**
     *
     * @param isbn
     * @param access
     */
    @Override
    public void changeBookAccessiblity(String isbn, boolean access) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE book SET borrowable=? WHERE isbn =?");
                preparedStatement.setBoolean(1, access);
                preparedStatement.setString(2, isbn);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    /**
     *
     * @param ISBN
     * @return
     */
    @Override
    public Book searchBookByISBN(String ISBN) {
        Book book = null;
        books.clear();
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM book WHERE isbn=? ");
                preparedStatement.setString(1, ISBN);
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    book = new Book(result.getInt("book_id"), result.getString("title"),
                            result.getString("isbn"), result.getBoolean("available"), result.getBoolean("borrowable"));
                    books.add(book);
                }
            }
        } catch (SQLException | BookException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
        return book;
    }

    @Override
    public Book searchBookByTitle(String title) {
        Book book = null;
        books.clear();
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM book WHERE title=? ");
                preparedStatement.setString(1, title);
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    book = new Book(result.getInt("book_id"), result.getString("title"),
                            result.getString("isbn"), result.getBoolean("available"), result.getBoolean("borrowable"));
                    books.add(book);
                }
            }
        } catch (SQLException | BookException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
        return book;
    }

    @Override
    public Book searchBookById(int bookId) {
        Book book = null;
        books.clear();
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM book WHERE book_id=? ");
                preparedStatement.setInt(1, bookId);
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    book = new Book(result.getInt("book_id"), result.getString("title"),
                            result.getString("isbn"), result.getBoolean("available"), result.getBoolean("borrowable"));
                    books.add(book);
                }
            }
        } catch (SQLException | BookException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
        return book;
    }

    /**
     * Gets all the available books from the database
     */
    @Override
    public void searchAvailableBooks() {
        Book book;
        books.clear();
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM book WHERE available=?");
                preparedStatement.setBoolean(1, true);
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    book = new Book(result.getInt("book_id"), result.getString("title"),
                            result.getString("isbn"), result.getBoolean("available"), result.getBoolean("borrowable"));
                    books.add(book);
                }
            }
        } catch (SQLException | BookException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    /**
     * Gets all the accessible books from the database
     */
    @Override
    public void searchAccessibleBooks() {
        Book book;
        books.clear();
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM book WHERE borrowable=?");
                preparedStatement.setBoolean(1, true);
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    book = new Book(result.getInt("book_id"), result.getString("title"),
                            result.getString("isbn"), result.getBoolean("available"), result.getBoolean("borrowable"));
                    books.add(book);
                }
            }
        } catch (SQLException | BookException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }

    }

    /**
     * Gets all the books from the database
     *
     * @return
     */
    @Override
    public List<Book> getAllBooks() {
        Book book;
        books.clear();
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM book ");
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    book = new Book(result.getInt("book_id"), result.getString("title"),
                            result.getString("isbn"), result.getBoolean("available"), result.getBoolean("borrowable"));
                    books.add(book);
                }
            }
        } catch (SQLException | BookException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
        return books;
    }

    /**
     * Displays all the books
     *
     * @throws BookException
     */
    @Override
    public void displayBooks() throws BookException {
        if (books.isEmpty()) {
            throw new BookException(BOOK_NOT_FOUND_MSG);
        }
        books.forEach((book) -> System.out.println(book));
    }

    /**
     *
     * @param isbn
     * @return
     */
    @Override
    public int getBookId(String isbn) {
        int bookId;
        try {
            Book book = searchBookByISBN(isbn);
            bookId = book.getBookId();
        } catch (NullPointerException ex) {
            System.err.println(String.format("Error: Book Does Not Exists"));
            bookId = 0;
        }
        return bookId;
    }

}
