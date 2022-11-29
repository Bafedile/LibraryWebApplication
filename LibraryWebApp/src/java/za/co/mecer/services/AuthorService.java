package za.co.mecer.services;

import java.util.List;
import za.co.mecer.modelImpl.Author;
import za.co.mecer.modelImpl.AuthorBook;
import za.co.mecer.modelImpl.Book;

/**
 *
 * @author Dimakatso Sebatane
 */
public interface AuthorService {

    public List<Author> getAuthors();

    public List<AuthorBook> getAuthorBooks();

    public void addAuthorBook(AuthorBook authorBook);

    public void addAuthor(Author author);

    public void addBook(Book book);
}
