package za.co.mecer.modelImpl;

import java.sql.SQLException;
import za.co.mecer.model.Authors;
import za.co.mecer.exceptions.AuthorException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Author implements Authors {

    private String name;
    private int authorId;

    /**
     *
     * @param authorId
     * @throws SQLException
     */
    public Author(int authorId) throws SQLException, AuthorException {
        this.setAuthorId(authorId);
    }

    /**
     *
     * @param authorId
     * @param name
     * @throws AuthorException
     * @throws SQLException
     */
    public Author(int authorId, String name) throws AuthorException, SQLException {
        this.setName(name);
        this.setAuthorId(authorId);
    }

    /**
     *
     * @param name
     * @throws AuthorException
     * @throws SQLException
     */
    public Author(String name) throws AuthorException, SQLException {
        this.setName(name);
    }

    /**
     *
     * @param name
     * @throws za.co.mecer.exceptions.AuthorException
     */
    @Override
    public void setName(String name) throws AuthorException {
        if (name.length() <= 0) {
            throw new AuthorException(NAME_ERROR_MSG);
        }
        this.name = name;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Author Name: %s%n"
                + "Author Id: %d%n",
                name, authorId);
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
        if (authorId < 1) {
            throw new AuthorException(AUTHOR_ID_ERROR_MSG);
        }

        this.authorId = authorId;
    }
}
