package za.co.mecer.model;

import java.util.List;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.exceptions.BookException;
import za.co.mecer.modelImpl.AuthorBook;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface AuthorBooks {

    public void setBookId(int bookId) throws BookException;

    public int getBookId();

    public int getAuthorId();

    public void setAuthorId(int authorId) throws AuthorException;

}
