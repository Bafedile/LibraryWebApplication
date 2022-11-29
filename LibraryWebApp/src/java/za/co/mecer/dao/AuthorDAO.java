package za.co.mecer.dao;

import java.util.List;
import za.co.mecer.modelImpl.Author;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface AuthorDAO {

    public String AUTHOR_ERROR_MSG = "Either Your Connection Or The Author is Null!!!";

    public void addAuthor(Author author);

    public void removeAuthor(int authorId);

    public Author searchAuthor(String name);

    public List<Author> getAllAuthors();

    public void displayAuthors();

    public String getAuthorName(int authorId);

    public int getAuthorId(String name);

    public Author searchAuthorById(int authorId);

    public List<Author> getAuthors();

}
