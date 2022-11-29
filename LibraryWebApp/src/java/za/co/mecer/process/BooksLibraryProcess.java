package za.co.mecer.process;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.mecer.exceptions.AuthorException;
import za.co.mecer.exceptions.BookException;
import za.co.mecer.modelImpl.Author;
import za.co.mecer.modelImpl.AuthorBook;
import za.co.mecer.modelImpl.Book;
import za.co.mecer.serviceimpl.AuthorServiceImpl;
import za.co.mecer.serviceimpl.BookServiceImpl;
import za.co.mecer.services.AuthorService;
import za.co.mecer.services.BookService;

/**
 *
 * @author Dimakatso Sebatane
 */
//@WebServlet("/books")
public class BooksLibraryProcess {

    public void processGetBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AuthorService authorService = new AuthorServiceImpl();
            List<AuthorBook> authorBookList = authorService.getAuthorBooks();
            request.setAttribute("books", authorBookList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("bookLibrary");
            dispatcher.forward(request, response);
        } catch (SQLException sql) {
            System.out.println(String.format("Error: %s%n", sql.getMessage()));
        }
    }

    public void processAddBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        try {
            AuthorService authorService = new AuthorServiceImpl();
            Author author = new Author(request.getParameter("author"));
            Book book = new Book(request.getParameter("title"), request.getParameter("isbn"),
                    Boolean.parseBoolean(request.getParameter("available")),
                    Boolean.parseBoolean(request.getParameter("borrowable")));

            AuthorBook authorBook = new AuthorBook(author, book);

            authorService.addBook(book);
            authorService.addAuthor(author);
            authorService.addAuthorBook(authorBook);
        } catch (AuthorException | BookException iox) {
            System.out.println(String.format("Error: %s%n", iox.getMessage()));
        }

    }
}
