package za.co.mecer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.mecer.dao.AuthorBookDAO;
import za.co.mecer.dao.AuthorDAO;
import za.co.mecer.dao.BookDAO;
import za.co.mecer.dao.ClosingDAO;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.modelImpl.Author;
import za.co.mecer.modelImpl.AuthorBook;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AuthorBookDAOImpl implements AuthorBookDAO, ClosingDAO {

    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;
    private AuthorDAO authorDao;
    private BookDAO bookDao;
    Connection conn = null;
    List<Author> authors = new ArrayList<>();

    /**
     *
     * @param conn
     */
    public AuthorBookDAOImpl() {
        this.conn = DatabaseConnection.getInstance().getConnection();
    }

    /**
     *
     * @param authorId
     * @param bookId
     */
    @Override
    public void addAuthorBook(int authorId, int bookId) {
        try {
            if (conn != null) {

                preparedStatement = conn.prepareStatement("INSERT INTO author_book (author_id, book_id) VALUES (?,?)");
                preparedStatement.setInt(1, authorId);
                preparedStatement.setInt(2, bookId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage() + "\n");
        } finally {
            close(preparedStatement, result);
        }
    }

    /**
     *
     * @param authorId
     * @param bookId
     */
    @Override
    public void removeAuthorBook(int authorId, int bookId) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("DELETE  FROM author_book WHERE author_id = ? AND book_id = ?");
                preparedStatement.setInt(1, authorId);
                preparedStatement.setInt(2, bookId);
                preparedStatement.executeUpdate();

                new AuthorDAOImpl().removeAuthor(authorId);
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    /**
     *
     * @param bookId
     * @return
     */
    @Override
    public String getBookIsbn(int bookId) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT isbn FROM book WHERE book_id=? ");
                result = preparedStatement.executeQuery();

                if (result.next()) {
                    return result.getString("isbn");
                }
            }
        } catch (SQLException se) {
            System.err.println("Error: " + se.getMessage());
        }

        return null;
    }

    @Override
    public List<AuthorBook> displayAuthorAndBook() {
        List<Author> authors = new ArrayList<>();
        List<AuthorBook> authorBooks = new ArrayList<>();
        try {
            if (conn != null) {
                authorDao = new AuthorDAOImpl();
                bookDao = new BookDAOImpl();

                authors = authorDao.getAllAuthors();

                for (Author author : authors) {
                    preparedStatement = conn.prepareStatement("SELECT book_id FROM author_book WHERE author_id = ?");
                    preparedStatement.setInt(1, author.getAuthorId());
                    result = preparedStatement.executeQuery();
                    if (result.next()) {
                        authorBooks.add(new AuthorBook(author, bookDao.searchBookById(result.getInt("book_id"))));
                        System.out.println(String.format("%s%s%n%n", author, bookDao.searchBookById(result.getInt("book_id"))));
                    }
                }
            }
        } catch (SQLException se) {
            System.err.println("Error: " + se.getMessage());
        }
        return authorBooks;
    }
}
