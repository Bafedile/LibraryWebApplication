package za.co.mecer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.mecer.model.Authors;
import za.co.mecer.dao.AuthorDAO;
import za.co.mecer.dao.ClosingDAO;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.modelImpl.Author;

/**
 *
 * @author Dimakatso Sebatane
 */
public class AuthorDAOImpl implements AuthorDAO, ClosingDAO {

    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;
    Connection conn = null;
    private AuthorBookDAOImpl authorBookImpl;
    List<Author> authors = new ArrayList<>();

    /**
     *
     * @param conn
     */
    public AuthorDAOImpl() {
        conn = DatabaseConnection.getInstance().getConnection();
        this.authorBookImpl = new AuthorBookDAOImpl();
    }

    /**
     *
     * @param author
     */
    @Override
    public void addAuthor(Author author) {
        try {
            if (conn != null && author != null) {
                preparedStatement = conn.prepareStatement("INSERT INTO author (name) VALUES (?)");
                preparedStatement.setString(1, author.getName());
                preparedStatement.executeUpdate();

            } else {
                throw new AuthorException(AUTHOR_ERROR_MSG);
            }

        } catch (SQLException | AuthorException se) {
            System.err.println("Error " + se.getMessage() + "\n");
        } finally {
            close(preparedStatement, result);
        }
    }

    /**
     *
     * @param authorId
     */
    @Override
    public void removeAuthor(int authorId) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("DELETE  FROM author WHERE author_id = ?");
                preparedStatement.setInt(1, authorId);
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
     * @param name
     * @return
     */
    public int getAuthorId(String name) {
        Author author = searchAuthor(name);
        int authorId = author.getAuthorId();
        return authorId;
    }

    @Override
    public String getAuthorName(int authorId) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT name FROM author WHERE author_id = ? ");
                preparedStatement.setInt(1, authorId);
                result = preparedStatement.executeQuery();
                if (result.next()) {
                    return result.getString("name");
                }
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
        return null;
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public Author searchAuthor(String name) {
        Author author = null;
        authors.clear();
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM author WHERE name = ? ");
                preparedStatement.setString(1, name);
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    author = new Author(result.getInt("author_id"), result.getString("name"));
                    authors.add(author);
                }
            }
        } catch (SQLException | AuthorException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }

        return author;
    }

    @Override
    public Author searchAuthorById(int authorId) {
        Author author = null;
        authors.clear();
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM author WHERE author_id = ? ");
                preparedStatement.setInt(1, authorId);
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    author = new Author(result.getInt("author_id"), result.getString("name"));
                    authors.add(author);
                }
            }
        } catch (SQLException | AuthorException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }

        return author;
    }

    /**
     * Returns all authors in the database
     */
    @Override
    public List<Author> getAllAuthors() {

        Author author = null;
        authors.clear();

        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM author");
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    author = new Author(result.getInt("author_id"), result.getString("name"));
                    authors.add(author);
                }

            }
        } catch (SQLException | AuthorException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
        return authors;
    }

    /**
     * Displays all the authors
     */
    @Override
    public void displayAuthors() {
        authors.forEach((author) -> System.out.println(author));
    }

    @Override
    public List<Author> getAuthors() {
        return authors;
    }

}
