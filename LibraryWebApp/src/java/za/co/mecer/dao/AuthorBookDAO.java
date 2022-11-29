package za.co.mecer.dao;

import java.util.List;
import za.co.mecer.modelImpl.AuthorBook;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface AuthorBookDAO {

    public void addAuthorBook(int authorId, int bookId);

    public void removeAuthorBook(int authorId, int bookId);

    public String getBookIsbn(int bookId);

    public List<AuthorBook> displayAuthorAndBook();

}
